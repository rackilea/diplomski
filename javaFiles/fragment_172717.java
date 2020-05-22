public class Test {

    static Test obj1,obj2,obj3; //3 references/variables
  //  ^
  //added static keyword


    public static void main(String ar[]) {  
        new Test(); //1 object
        obj2=obj3=new Test(); //second object created
    //  ^obj2,obj3 both are referring the 2nd object now
    }
}