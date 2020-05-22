public class AnonymousTest {


    public static void main(String[] args){

        Object obj = someObject("Hey world!");
        System.out.println(obj);
    }

    public static Object someObject(String str){
        return new Object(){
            public String toString(){
                return super.toString()+str;
            }
        };
    }
}