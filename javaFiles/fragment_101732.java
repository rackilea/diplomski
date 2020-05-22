import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLNonTransientConnectionException;
import java.util.ArrayList;
import java.util.List;
import org.apache.derby.drda.NetworkServerControl;

public class DerbyInMemoryEmbeddedServer {

    public static void main(String[] args) throws Exception {
        NetworkServerControl server = new NetworkServerControl(InetAddress.getByName("localhost"), 1528);
        server.start(null);

        String connectionString = "jdbc:derby://localhost:1528/memory:hello_world_database;create=true";
        Connection conn = DriverManager.getConnection(connectionString);
        System.out.println("Server started");

        //create the database here. The following is an example:

        //create the users table
        try (PreparedStatement ps = conn.prepareStatement(
                "create table users ("
                + "id int not null generated always as identity, "
                + "username varchar(8000), "
                + "first_name varchar(8000), "
                + "surname varchar(8000), "
                + "primary key (id), "
                + "constraint uc_username unique (username)"
                + ")")) {
            ps.execute();
        }

        //create an index
        try (PreparedStatement ps = conn.prepareStatement(
                "create index ix_surname on users (surname)")) {
            ps.execute();
        }

        //add some users
        List<String> names = new ArrayList<>();
        names.add("jhuff|Jeffrey|Huffines");
        names.add("woodsey223|Sherwood|Gurule");
        names.add("tim_w|Tim|Woods");
        try (PreparedStatement ps = conn.prepareStatement("insert into users (username, first_name, surname) values (?, ?, ?)")) {

            for (String name : names) {
                String[] tokens = name.split("\\|");

                ps.setString(1, tokens[0]);
                ps.setString(2, tokens[1]);
                ps.setString(3, tokens[2]);
                ps.addBatch();
            }

            ps.executeBatch();
        }

        //create the team table
        try (PreparedStatement ps = conn.prepareStatement(
                "create table team ("
                + "id int not null generated always as identity, "
                + "name varchar(8000), "
                + "primary key (id),"
                + "constraint uc_team_name unique (name)"
                + ")")) {
            ps.execute();
        }

        //insert a team
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into team (name) values (?)")) {
            ps.setString(1, "Wombats");
            ps.executeUpdate();
        }

        //create a many-to-many table to link teams to users. (Since a user can belong to more than one team)
        try (PreparedStatement ps = conn.prepareStatement(
                "create table team_member ("
                + "id int not null generated always as identity, "
                + "team_id int not null, "
                + "user_id int not null,"
                + "constraint fk_team_member_team foreign key (team_id) references team(id), "
                + "constraint fl_team_member_user foreign key (user_id) references users(id), "
                + "primary key (id)"
                + ")")) {
            ps.execute();
        }

        //create team members
        List<String> teamMembers = new ArrayList<>();
        teamMembers.add("jhuff|Wombats");
        teamMembers.add("tim_w|Wombats");

        try (PreparedStatement ps = conn.prepareStatement("insert into team_member (team_id, user_id) values ("
                + "(select id from team where name = ?),"
                + "(select id from users where username = ?)"
                + ")")) {

            for (String teamMember : teamMembers) {
                String[] tokens = teamMember.split("\\|");

                ps.setString(1, tokens[1]);
                ps.setString(2, tokens[0]);
                ps.addBatch();
            }
            ps.executeBatch();
        }

        System.out.println("Server ready");
        System.in.read();

        System.out.println("Disconnecting");
        String shutdownConnectionString = connectionString + ";shutdown=true";

        try {
            DriverManager.getConnection(shutdownConnectionString);
        } catch (SQLNonTransientConnectionException ex) {
            //derby throws an exception on disconnection
        }

        System.out.println("Disconnected");
    }
}