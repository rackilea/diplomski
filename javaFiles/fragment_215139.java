public class test {

    ClassList cl[] = new ClassList[5];

    public test(){
        cl[0] = new ClassList("index 1", "name1");
        cl[1] = new ClassList("index 2", "name2");
        cl[2] = new ClassList("index 3", "name3");
        cl[3] = new ClassList("index 4", "name4");
        cl[4] = new ClassList("index 5", "name5");

        for(int i = 0; i<cl.length; i++){
            System.out.println(cl[i].getA()+" "+cl[i].getB());
        }
    }
     public static void main(String args[]){
         new test();

     }
}

class ClassList{
    String a;
    String b;
    public ClassList(String a,String b){
        this.a = a;
        this.b = b;
    }
    public String getA(){   return a;   }
    public String getB(){   return b;   }
}