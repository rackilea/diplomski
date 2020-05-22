public static void main(String args[])throws IOException
{
    char tmp;
    String str;
    StringBuffer rese=new StringBuffer();
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    FileOutputStream foute=new FileOutputStream("Even.txt");
    FileOutputStream fouto=new FileOutputStream("Odd.txt");
    System.out.print("\nEnter a String :");
    str=br.readLine();
    System.out.print("\n Length : "+str.length() + "\n");

    for(int i = 0;i < str.length(); i++)
    {
        char c=str.charAt(i);
        if(i%2 == 0)
            foute.write(c);
        else
            fouto.write(c);
    }

    foute.close();
    fouto.close();

    FileInputStream fine=new FileInputStream("Even.txt");
    FileInputStream fino=new FileInputStream("Odd.txt");

    String s = "";
    while(fine.available() > 0)
    {
        s += (char) fine.read();
    }

    fine.close();
    fino.close();
    System.out.print("In even file : " + s);
}