public class ScannerTest {


    public static void main(String ...args)throws ClassNotFoundException,SQLException,FileNotFoundException {

        File f =new File("/home/rahul/Desktop/emp.txt");
        Scanner s=new Scanner(f);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection("jdbc:oracle:thin:@172.22.22.131:1521:orcl","Demo","demo");
        while(s.hasNext())
        {

        PreparedStatement st=con.prepareStatement("Insert into Employee values(?,?,?)");

        String rcd = s.next();
        Scanner s1 = new Scanner(rcd);
        s1.useDelimiter(",|\\n");

        String name=s1.next();
        int  id=s1.nextInt();
        int sal=s1.nextInt();

        st.setString(1,name);
        st.setInt(2,id);
        st.setInt(3,sal);

        int result=st.executeUpdate();
        System.out.println("Records Changed: "+ result);

        }
        con.close();

    }

 }
}