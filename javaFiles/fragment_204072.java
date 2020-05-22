public java.sql.Date checkdate(String Dob)
{
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
    try {
       java.util.Date yourDate = sdf.parse( Dob );
       java.sql.Date yoursqlDate= new java.sql.Date(yourDate.getTime());
       return yoursqlDate;
    } catch ( Exception ex ) {
       // Your Catch Block
    }
    return null;
}