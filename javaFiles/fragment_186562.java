public ArrayList getdata(String query, boolean test, List<CartEntry> items)
    {
ArrayList arr = new ArrayList();// This is a ArrayList
        int k;
            try
            {
                Connection conn;
                Statement st;
                public ResultSet rs,result;
                List<Product> prodList = new ArrayList<Product>();
                for(CartEntry ce : items)
                {
                    prodList.add(new Product("p" + ce.getpId(), "test", "prod" + ce.getpId(), (int)ce.getpId(), ce.getpId() + 0.12f, ce.getQuantity()));
                    result = new DummyResultSet(prodList);
                    k = ce.getQuantity();
                    System.out.println(k);
                }

                st=conn.createStatement();
                rs=st.executeQuery(query);          
                querystatus=true;
arr.add(rs);// Add it to list
arr.add(result);
                return arr; // Return the List
            }
            catch(Exception e)
            {
                querystatus=false;
            }
        }