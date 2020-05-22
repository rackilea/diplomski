import java.io.*;

class reader{
    public static void main(String[] args)throws Exception{
        File file = new File("test.txt");     
        BufferedReader fi = new BufferedReader(new FileReader(file));
        String num;
        int count = 0;

        while ((num = fi.readLine()) !=null) {
            String [] add = num.split(" ");      
            for(int i=0; i<add.length;i++){
               String pair = add[i].substring(1, 4);
                someFunction(pair.split(","));
                }
            }
        }

public static void someFunction(String[] args)
  {
    if(args.length > 0)
      System.out.println(args[0] + " and " + args[1]);
  }

    }