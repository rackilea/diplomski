public static void main (String[] args) 
{
    String stat = "INSERT INTO DEPARTMENT(DNO, NAME, TEST_ID) VALUES (2, 'ADM', 1)";
    System.out.println("Table Name: " + stat.substring(stat.indexOf("INSERT INTO ") + 12,stat.indexOf("(")));
    System.out.println("Column Names: " + stat.substring(stat.indexOf("(") + 1,stat.indexOf(")")));
    System.out.println("Column Values: " + stat.substring(stat.indexOf("VALUES (") + 8,stat.lastIndexOf(")")));
}