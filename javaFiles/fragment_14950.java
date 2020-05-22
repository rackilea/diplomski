private static final String TABLE_NAME = "product";
private static final String ID_COLUMN = "id";
private static final String INTRO_COLUMN = "intro";
private static final String CONTENT_COLUMN = "content";
private static final String PRICE_COLUMN = "price";

private static final String FETCHALLPRODUCTS_QUERY = String.format("SELECT %s, %s, %s, %s FROM %s", ID_COLUMN, INTRO_COLUMN, CONTENT_COLUMN, PRICE_COLUMN, TABLE_NAME);

public Map<Integer, Product> fetchAllProducts() {

  Map<Integer, Product> pArr = new HashMap();
  try {
     Statement st = conn.createStatement();
     ResultSet rs = st.executeQuery(FETCHALLPRODUCTS_QUERY);
     while (rs.next()) {
        Integer price = rs.getInt(PRICE_COLUMN);
        String content = rs.getString(CONTENT_COLUMN);
        String intro = rs.getString(INTRO_COLUMN);

        Product product = new Product(price, content, intro);
        Integer id = rs.getInt(ID_COLUMN);
        pArr.put(id, product);
     }
     st.close();
  } catch (SQLException ex) {
   //...
  }
  return pArr;
}