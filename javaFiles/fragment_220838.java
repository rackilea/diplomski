private JdbcTemplate jdbcTemplate; //it depends on your config how to get it here.

List<OwnerSale> ownerSaleReport(Long ownerId){
    String sql = "SELECT title FROM content where id=:contentId"
    return jdbcTemplate.query(StringUtils.replaceEach(sql,
               new String[]{":contentId"},
               new String[]{ownerId.toString()}),
               (rs, i) -> {
                   OwnerSale ownerSale = new OwnerSale();
                   ownerSale.setTitle(rs.getString("title"));//(or using constructor)
                   return ownerSale;
               });
}