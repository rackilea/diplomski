while(rs.next()) {
    Shop currShop = new Shop();
    currShop.setName(rs.getString(1));
    currShop.setDescription(rs.getString(2));
    System.out.println(listShops.add(currShop));
}