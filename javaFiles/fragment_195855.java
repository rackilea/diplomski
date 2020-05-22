public class TestDemo {
        public static int count = 0;


        DataProvider(name = "therapistToDoList") public static Object[][] data(){
            return new Object[][]{
               {"06012017", "Low", "This is a low task description added via automation for therapist/admin."},
               {"06012017", "Medium", "This is medium task description added via automation for therapist/admin."},
               {"06012017", "High", "This is high task description added via automation for therapist/admin."},
            };
       }

       @Test(dataProvider = "therapistToDoList")
       public void testWithSpecificDataFromDataProvider(String a, String b, String c) {
           count++;
          if(count == 2){//let's say you are interest in 2nd data/row
          System.out.println(a + " " + b + " " + c);
          break;
          }
       }

}