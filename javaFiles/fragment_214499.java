public Employee selectById( int id ) {
      // Commenting out the previous implementation...
      // String query = select * from employee where id = ? 
      // execute( query )  

      // Using the ORM solution

       Session session = getSession();
       Employee e = ( Employee ) session.get( Employee.clas, id );
       return e;
}