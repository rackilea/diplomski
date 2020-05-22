@Repository
public class GroupPostgresRepository implements GroupRepository {

    private final JdbcTemplate jdbcTemplate;

    public GroupPostgresRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Group> getAllGroups() {
        final String sql = "SELECT id_grupy, nazwa, id_egzaminatora, haslo, egzaminatorzy_id_egzaminatora FROM grupy";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Group group = new Group();
            group.setId_grupy(rs.getInt(1));
            group.setNazwa(rs.getString(2));
            group.setId_egzaminatora(rs.getInt(3));
            group.setHaslo(rs.getString(4));
            group.setEgzaminatorzy_id_egzaminatora(rs.getInt(5));
            return group;
        });
    }

}