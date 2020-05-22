public class MonthOrderCountHandler extends BasicRowProcessor {

    @Override
    public List toBeanList(ResultSet rs, Class clazz) {
        try {
            List newlist = new LinkedList();
            while (rs.next()) {
                newlist.add(toBean(rs, clazz));
            }
            return newlist;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Object toBean(ResultSet rs, Class type) throws SQLException {

        // Year
        Year year = new Year();
        year.setYearNo(rs.getInt("yearNo"));
        year.setYear4(rs.getString("year4"));
        year.setYear2(rs.getString("year2"));

        // Quarter
        Quarter quarter = new Quarter();
        quarter.setQuarterNo(rs.getInt("quarterNo"));

        // Month
        Month m = new Month();
        m.setYear(year);
        m.setQuarter(quarter);
        m.setMonthAbbreviation(rs.getString("monthAbbreviation"));
        m.setMonthName(rs.getString("monthName"));
        m.setMonthNo(rs.getInt("monthNo"));

        // Final bean
        MonthOrderCount result = new MonthOrderCount();
        result.setMonth(m);
        result.setOrderCount(rs.getInt("orderCount"));

        return result;

    }
}