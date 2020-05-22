import java.util.*;
    import java.lang.*;
    import java.io.*;


    class Ideone
    {
        public static void main (String[] args) throws java.lang.Exception
        {
            ArrayList<String[]> strArrayList= new ArrayList<String[]>();
            String[] str1={"16","1421","1577"};

            String[] str2={"15","1451","1461","6556"};

            String[] str3={"157","8751","1136","556","879"};

            strArrayList.add(str1);
            strArrayList.add(str2);
            strArrayList.add(str3);


            int sizeOfArr=0;
            int i=0;

            for (String[] s : strArrayList)
            {

                sizeOfArr+=s.length;
            }

            int[] ArrayRes = new int[sizeOfArr];


            for (String[] s : strArrayList)
            {
                if(s.length>0){
                    for (String s1 : s){
                        ArrayRes[i] = Integer.parseInt(s1);
                        System.out.println(ArrayRes[i]);
                        i++;
                    }
                }
            }

        }
    }