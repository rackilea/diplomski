public class Test{


public static void main(String[] args){

        ArrayList<Player> pList = new ArrayList<Player>();

       String name = jName.getText().toString();
       long score = Long.parseLong(jScore.getText().toString());
       int age =  Integer.parseInt(jAge.getText().toString());
       int gTemp = Integer.parseInt(jTemp.getText().toString());


       pList.add(new Player(gTemp, name, age, score));


   }


}