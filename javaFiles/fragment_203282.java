@RequestMapping(value ="/{serialNumber}", method = RequestMethod.GET)
@ResponseBody
public void searchByStudent(@PathVariable("serialNumber") String serialNumber) {
    SqlRowSet resultSet = this.jdbcTemplate.queryForRowSet("SELECT * FROM STORE_ITEMS WHERE SERIALNUMBER = ?", new Object[] {serialNumber});
    System.out.println(resultSet);
}