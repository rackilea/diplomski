public class HelloWorld{

     public static void main(String []args){

        int z = 26;
        int b = 0;
        int x = 1;
        int w = 2;
        int y = 1;

        for (int i = 1;i<=z;i++) {
            b = b+(b*y)+x+w;
            if (i % 5 == 0)
                System.out.println("In " + i + " years, IRA value: " + b);          
        }

        System.out.print(z);
     }
}