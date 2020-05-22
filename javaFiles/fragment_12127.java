//Added another parameter for the method that takes the product code.
        public void purchased(string productCode, int qtyPurchased) throws SQLException 
        {
            try (Connection conn = SimpleDataSource.getConnection()) 
            {
                //Updated prepared statement to update a product row instead of inserting a new one using the specified product code.
                try (PreparedStatement stat = conn.prepareStatement("UPDATE ProductsDB SET Quantity = ? WHERE Product_Code = ?") 
                {
                    //Update the values used in the prepared statement
                    stat.setInt(1, qtyPurchased);
                    stat.setString(2, productCode);

                    //Execute the statement (important)
                    stat.execute();
                }
            }
        }