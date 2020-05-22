public class PetByPersonIdRowMapper implements RowMapper<PersonPetDetails> {
    @Override
    public BillingFeeConfigEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        PersonPetDetails record = new PersonPetDetails();

        record.setPersonId(rs.getLong("personId"));
      record.setPetId(rs.getLong("petid");
      ...
      ...
}