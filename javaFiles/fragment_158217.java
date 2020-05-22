public class MyProgram
    {
    public static void main(String[] args)
    {
    String  x = "hello";



    System.out.println(back(x));





    }


      public static String back(String str )
      {

          String temp = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            char lets = str.charAt(i);
            temp = temp + lets;

        }

        if (temp.equals("olleh")) {
            System.out.println("nice");
        }
        return temp;

    }
    }