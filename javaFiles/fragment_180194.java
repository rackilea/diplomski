Product u = new Product();
ArrayList<Object> productList = new ArrayList<Object>();
try 
            {                   
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
                    while (rs.next())
                    {
                        int proID = rs.getInt("productID");
                        String productName = rs.getString("productName");
                        String productTyp  = rs.getString("productType");
                        String productDiscription = rs.getString("productDiscription");
                        int productPrice = rs.getInt("productPrice");                            
                        String productSize = rs.getString("productSize");
                        String productPicURL =rs.getString("productPicURL");                     
                        u = new Product(proID,productName,productTyp,productDiscription,productPrice,productSize,productPicURL);
                        productList.add(u);
                   }        
                        con.close();
                    } 
            catch (SQLException | NullPointerException e)
                    {
                        e.printStackTrace();
                    }
           httpRequest.setAttribute("prodList", productList);