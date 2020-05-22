public List<EmployeeHolidays> retrieveHolidays(Date startDate,Date endDate){
        String sql = "SELECT * FROM HOLIDAYS WHERE DATE >= ? AND DATE <= ? ";
        List<EmployeeHolidays> list = template.query(
sql ,
new Object[] { startDate, endDate} //add this
new RowMapper<EmployeeHolidays>(){
            public EmployeeHolidays mapRow(ResultSet rs,int rownumber) throws SQLException{
                EmployeeHolidays e = new EmployeeHolidays();
                e.setDate(rs.getDate(1));
                e.setReason(rs.getString(2));
                e.setStatus(rs.getString(3));
                return e;
            }
        });
        return list;
    }