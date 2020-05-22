<% 
            return; 
        }//if
    }//try
    finally 
    {
        try
        {
            con.close();
        }catch(Exception e){}
    }//finally
    %>