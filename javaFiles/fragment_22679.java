public int present(){

   // make query for Oracle data base
       String yourQry = "select * from yourtable where password = '"+pass+"' and username='"+username+"'" . 
    //Use this query when you are fetching data from user.
    Resultset rs;// fetch your data in resultset
         if(rs.next()){
               // if data got fetched 
               return 1;// In other languages(C,C++) 0 and 1 are treated as true or false
               // 1 means true
          }
         else{
                  return 0; // 0 means false (No datafound) 
         }

        }