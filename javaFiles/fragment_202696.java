public static void main(String[] args) {
    String input = "select * from table1 where col1 = 'abc;de'; select * from table2;";

    System.out.println(java.util.Arrays.toString(
        input.split("\\s*;\\s*(?=([^']*'[^']*')*[^']*$)")
    )); // prints "[select * from table1 where col1 = 'abc;de', select * from table2]"

}