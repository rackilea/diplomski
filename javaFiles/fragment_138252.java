Map<String, Object> in = new HashMap<String, Object>();
        in.put("products", new AbstractSqlTypeValue() {
            @Override
            protected Object createTypeValue(Connection con, int type, String typeName) throws SQLException {
                Struct[] productList = new Struct[1];
                Object[] customObject = new Object[]{"Vegetables"};
                productList[0] = con.createStruct("ProductRow", customObject);

                Array products = con.createArrayOf("ProductRow", productList);
                return products;
            }
        });