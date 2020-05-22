boolean isCNICFound = false;
 while(rs.next())
   {    


       CNICc=rs.getString(5);
       //out.println(CNIC);
       //UNamec=rs.getString(1)
           System.out.println("From Result Set : " + CNICc + " -comparing this with : " + CNIC);
           if(null != CNICc) {
               if(CNIC.equals(CNICc)) {
                  isCNICFound = true;
                   break;
                }
           }           
      }

if(isCNICFound ){
 pageContext.forward("Hitchhiker-error.jsp");
} else {
ps.executeUpdate();
                pageContext.forward("Hitchhiker-success-register.jsp");
}