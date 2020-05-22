public ArrayList<String> takeNames(){
        //This will collect all names from db
        ArrayList<String> names = new ArrayList<>();

        try{
            conn = dbConnector();
            query = "select distinct Name from DbTable order by Name";
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                //shows Name data in combobox
                //Add data to the array list
                 names.add(rs.getString("Name"));
            }               
            pst.close();                
        }

        catch(Exception ex){
            ex.printStackTrace();
        }

        //Return the array list you created
        return names;
      }