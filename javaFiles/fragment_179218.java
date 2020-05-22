public class FileToDatabase {
    public static void main(String[] args) throws Exception {
            String fileName = "C:/input.txt";
            File file = new File(fileName);
            FileInputStream fis = new FileInputStream(file);
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                            "jdbc:mysql://localhost:3306/test", "root", "root");
            PreparedStatement pstmt = conn
                            .prepareStatement("insert into file( file, file_data) values ( ?, ?)");
            pstmt.setString(1, file.getName());
            pstmt.setBinaryStream(2, fis, (int) file.length());
            pstmt.executeUpdate();
    }