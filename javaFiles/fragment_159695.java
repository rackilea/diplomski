import java.io.*;
import java.lang.*;  

    class Solution{  

        public static void main(String[] args){  

            Scanner in = new Scanner(System.in);  

            int t=in.nextInt();  

            double s=0;  

            for(int i=0;i<t;i++){  

                int  a  =  in.nextInt();    

                int  b  =  in.nextInt(); 

                int n = in.nextInt();

                for(int j=0 ; j<n ; i++)  
                {  
                    s = s+(a+(java.lang.Math.pow(2, j))*b);  
                    System.out.print(s+" ");  
                }  
            }  
            in.close();  
        }  

    }