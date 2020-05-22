public static void main(String args[])throws IOException
            {
                BufferedReader br=new BufferedReader(new InputStreamReader(System.in));                                                                                          
                String s;
                for(int i=0;i<3;i++)
                {
                    System.out.print("->");
                    s=br.readLine();
                    System.out.print(s);
                }
            }