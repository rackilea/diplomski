public void makeCombo() throws SQLException{
public JComboBox warehouse = new JComboBox();           
try{
            Connection conn = Connect.getConnection();
            String query = "Select ?? FROM ??";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            if (rs!=null){
                while (rs.next()){
                    String name = rs.getString(1);
                    warehouse.addItem(name);
                }

            }
            else{
                System.err.println ("Empty combo");
                warehouse.addItem("Empty Combo");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }