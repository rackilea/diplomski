public void update(RowEditEvent event) {

        TesztSetGet edittedObject = (TesztSetGet) event.getObject();        

        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String sql = "update teszt set kapcsolatfelvetel_megtortent=?, levelkuldes_datuma=?, kepzes_kezdete=?, kepzes_vege=?, megjegyzes=?  where id=?";

        try{

            connection = getDBConnection();                                                                       
            pst = connection.prepareStatement(sql);



            pst.setString(1, edittedObject.getKapcsolatfelvetel_megtortent());
            pst.setString(2, edittedObject.getLevelkuldesenek_datuma());
            pst.setString(3, edittedObject.getKepzes_kezdete());
            pst.setString(4, edittedObject.getKepzes_vege());
            pst.setString(5, edittedObject.getMagyarazat());
            pst.setInt(6, edittedObject.getId());

            pst.executeUpdate();
            pst.close();
            connection.close();

            //UPDATE VALUES LIST WITH NEW DATA

        }catch(SQLException se){
            se.printStackTrace();
            se.getMessage();
         }catch(Exception e){
             e.printStackTrace();
             e.getMessage();
         }    


    }