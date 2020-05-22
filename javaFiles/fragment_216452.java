public class test
    {           
        public static void main(String[] args)
        {
            String s1 = "MICROSOFT";
            String s2 = "APPLESOFT";

            int counter1=0;
            int counter2=0;

            String[] test = new String[100];
            test[0]="";

            for(int j=0; j<s1.length(); j++)
            {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);

                if(c1==c2)
                {
                    if(counter1==counter2)
                    {
                        //System.out.println("Match found!!!");
                        test[0]=test[0]+c2;
                        counter2++;
                        //System.out.println("Counter 2: "+counter2);
                    }
                    else
                        test[0]="";
                }
               else
               {
                   //System.out.print("No match found!");
                   //System.out.println("Counter 2: "+counter2);
                   counter2=counter1+1;
                   test[0]="";
               }

               counter1++;
               //System.out.println("Counter 1: "+counter1);
                           }

             System.out.println(test[0]);
             System.out.println(s2.replaceAll(test[0]," "));
        }
    }