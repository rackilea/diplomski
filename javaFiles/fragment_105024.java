package database.mariadb.persistence;

import database.mariadb.model.Contact;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael
 * Creation date 3/21/2017.
 * @link
 */
public class ContactRepositoryImpl implements ContactRepository {

    private static final String FIND_ALL_SQL = "SELECT id, firstName, lastName, city, state, email from  contact ";
    private static final String INSERT_SQL = "INSERT INTO contact(firstName, lastName, city, state, email) values(?, ?, ?, ?, ?) ";

    private Connection connection;

    public ContactRepositoryImpl(DataSource dataSource) throws SQLException {
        this.connection = dataSource.getConnection();
    }

    public ContactRepositoryImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> result = new ArrayList<>();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery(FIND_ALL_SQL)) {
            while (rs.next()) {
                Long id = rs.getLong("id");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String email = rs.getString("email");
                result.add(new Contact(id, firstName, lastName, city, state, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void insert(Contact contact) {
        if (contact != null) {
            try (PreparedStatement ps = connection.prepareStatement(INSERT_SQL, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, contact.getFirstName());
                ps.setString(2, contact.getLastName());
                ps.setString(3, contact.getCity());
                ps.setString(4, contact.getState());
                ps.setString(5, contact.getEmail());
                int numRowsAffected = ps.executeUpdate();
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        contact.setId(rs.getLong(1));
                    }
                } catch (SQLException s) {
                    s.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}