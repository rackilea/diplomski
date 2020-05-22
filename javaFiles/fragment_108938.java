public class ExportToExcel {
    //{  remove this

    public static void main(String args[]) throws IOException {
        //{ remove this
        String source = "C:/Test/DATABASE.db";
        String target ="C:/Test/COPY_";


        File sourceFile = new File(source);
        String name = sourceFile.getName();

        File targetFile = new File(target+name);
        System.out.println("Copying file : " + sourceFile.getName());


        FileUtils.copyFile(sourceFile, targetFile);

        System.out.println("copying of file:"+ sourceFile.getName() +"is completed");

        Connection connection = null;
        //@Override
        //public Connection getConection() throws SQLException {


        try {
            Class.forName("org.sqlite.JDBC");


            connection = DriverManager.getConnection("jdbc:sqlite:" + "C:/Test/DATABASE.db"); 
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        } catch (Exception e) {
            throw new SQLException(e.getCause());
        }

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement
                .executeQuery("select * from MAIN_TABLE");
        XSSFWorkbook workbook = new XSSFWorkbook(); 
        XSSFSheet spreadsheet = workbook
                .createSheet("EXPORTED DB");
        XSSFRow row=spreadsheet.createRow(1);// should start at 0 not one.. But this is ok for testing..
        XSSFCell cell;
        cell=row.createCell(1);// should start at 0 not one.. But this is ok for testing..
        cell.setCellValue("Number");
        cell=row.createCell(2);
        cell.setCellValue("First Name");
        cell=row.createCell(3);
        cell.setCellValue("Last Name");
        cell=row.createCell(4);
        cell.setCellValue("Origin");
        cell=row.createCell(5);
        cell.setCellValue("Destination");
        cell=row.createCell(6);
        //
        cell.setCellValue("Arrival");
        cell=row.createCell(7);
        cell.setCellValue("Departure");     
        cell=row.createCell(8);
        cell.setCellValue("Status");
        cell=row.createCell(9);
        cell.setCellValue("Created");    
        cell=row.createCell(10);
        cell.setCellValue("Updated");   
        cell=row.createCell(11);
        cell.setCellValue("Message"); 
        cell=row.createCell(12);
        cell.setCellValue("Active");    
        //
        int i=2;
        while(resultSet.next())
        {
            row=spreadsheet.createRow(i);
            cell=row.createCell(1);
            cell.setCellValue(resultSet.getInt("number"));
            cell=row.createCell(2);
            cell.setCellValue(resultSet.getString("first_name"));
            cell=row.createCell(3);
            cell.setCellValue(resultSet.getString("last_name"));
            cell=row.createCell(4);
            cell.setCellValue(resultSet.getString("origin"));
            cell=row.createCell(5);
            cell.setCellValue(resultSet.getString("destination"));
            //
            cell=row.createCell(6);
            cell.setCellValue(resultSet.getString("arrival"));
            cell=row.createCell(7);
            cell.setCellValue(resultSet.getString("departure")); 
            cell=row.createCell(8);
            cell.setCellValue(resultSet.getString("status"));
            cell=row.createCell(9);
            cell.setCellValue(resultSet.getString("created"));
            cell=row.createCell(10);
            cell.setCellValue(resultSet.getString("updated"));
            cell=row.createCell(11);
            cell.setCellValue(resultSet.getString("message"));
            cell=row.createCell(12);
            cell.setCellValue(resultSet.getString("active"));
            //
            i++;
        }
        FileOutputStream out = new FileOutputStream(
                new File("exceldatabase.xlsx"));
        workbook.write(out);
        out.close();
        // workbook.close();
        System.out.println(
                "exceldatabase.xlsx written successfully");

        {    
            try{

                File filetodelete = new File("C:/Test/COPY_DATABASE.db");

                if(filetodelete.delete()){
                    System.out.println(filetodelete.getName() + " is deleted!");
                }else{
                    System.out.println("Delete has failed.");

                }

            }catch(Exception e){

                e.printStackTrace();
            }
        }
    }
}
//} remove this