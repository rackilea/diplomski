PreparedStatement pst  = null;
ResultSet rs = null;
try {
        pst = connectionUsers.prepareStatement(query);
        ...  
        rs = pst.executeQuery();
        ...                    
    } catch (Exception a) {
        a.printStackTrace();
    } finally {
        if(rs != null){
             try{
                  rs.close();
             } catch(Exception e){
                 e.printStackTrace();
             }
        }
        if(pst != null){
            try{
                pst.close();
            } catch(Exception e){
                e.printStackTrace();
            }
        }
    }