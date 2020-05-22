public static void main(String args[])throws IOException
           {
               BufferedReader br=new BufferedReader(new InputStreamReader(System.in));                                                                                          
               char s;
               for(int i=0;i<3;i++)
               {
                   System.out.print("->");
                   s=(char)br.read();
                   System.out.print(s);
               }
           }