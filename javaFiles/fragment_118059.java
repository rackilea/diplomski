public class Model{
     private String name;
     private String dob;
     private double balance;
     // getter and setter   
}

...

List<Model> list = new ArrayList<Model>();
//add the data in list

request.setAttribute("list",list);