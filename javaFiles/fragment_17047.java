package lists;

import java.util.ArrayList;
import java.util.List;


 public class Visit{
      public static List<VisitListVariables> BuildVisitList(){

        List<VisitListVariables> BuildVisitList = new ArrayList<>(); //creates List to return
        try{
          //Database connection variables
          //Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "password");
          //Statement stm;
          //stm = conn.createStatement();
          //String sql = "Select * From Customer";
          //ResultSet rs;
          //rs = stm.executeQuery(sql);


            //while(rs.next()){
              VisitListVariables buildList = new VisitListVariables(); //Gets variables needed for list
              //String visitDate = rs.getString("visitDate"); 
              String dateOfTheVisit = "today";
              buildList.setDateOfTheVisit(dateOfTheVisit);
              buildList.setCategory("Doctor Visit");
              buildList.setIdClient("666");
              buildList.setIdInsrurer("999");
              buildList.setIdDoctor("1001");
              buildList.setIdVisit("001");
              buildList.setAccepted("yes");

              BuildVisitList.add(buildList);
            //}
            //rs.close();stm.close();conn.close();

        }catch(Exception e){}




        return BuildVisitList;

      }
    }