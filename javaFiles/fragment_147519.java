protected void onPostExecute(ResultSet rsData)
        {
            try
            {
                int size=0;
                while(rsData.next())
                {
                    size++;
                }
                rsData.beforeFirst();
                mlst = new String[size];
                int i=0;
                while(rsData.next())
                {
                    String mid = rsData.getString(rsData.findColumn("mid"));
                    String uid = rsData.getString(rsData.findColumn("uid"));
                    String messages = rsData.getString(rsData.findColumn("message"));                             
                    String read=rsData.getString(rsData.findColumn("rstamp")); 
                    mdb.addMessage(new Contact(mid, uid, messages, read));
                    mlst[i]=mid;
                    i++;
                }
                con.UpdateMessage(mlst);
            } 
            catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }