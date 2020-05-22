import java.io.*;
import java.math.*;

class test {
    public static void main(String[] args){
        String[] s= {"1","0.12",".12"};
        int n = 3;

        for(int i=0;i<n;i++){

                BigDecimal  d=new BigDecimal(s[i]);

                for (int j =i+1; j<n; j++){

                  BigDecimal a=new BigDecimal(s[j]);

                        if(d.compareTo(a)==-1){
                            String m = s[j];
                            s[j]=s[i];
                            s[i]=m;

                        }
                    }
                }
                  //Output :
                     for(int i=0;i<n;i++)
                System.out.println(s[i]);

    }

}