public class InsertToWriteTo {

    public static void main(String[] args) {
        boolean ret = insert("\"hello\"", "college", "student");
        System.out.println(ret);
    }

    public static boolean insert(String string, String DBName, String tableName) {
        try {
            string = string.substring(string.indexOf('"') + 1, string.lastIndexOf('"')); // removes quotes

            File tableToWriteTo = new File(DBName + "/" + tableName + ".txt");
            if (tableToWriteTo.exists()) { // changed condition
                System.out.println("File exists");
                return false;
            }

            PrintWriter writer = new PrintWriter(new FileWriter(tableToWriteTo, true));
            writer.println(string);
            writer.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}