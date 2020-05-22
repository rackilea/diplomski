public class Test {
    public static void main(String...strings) {
        String data = "[{\'ID\': 0001, \'Name\': Black Shirt, \'Cost\': 3.00, \'Asle\':1},{\'ID\': 0002, \'Name\': White Shirt, \'Cost\': 2.00, \'Asle\':1}]";

        int idFrom, idTo, costFrom, costTo;
        String idStr = "{\'ID\': ";
        String nameStr = ", \'Name\': ";
        String costStr = ", \'Cost\': ";
        String asleStr = ", \'Asle\'";
        while(data.indexOf(idStr) != -1) {
            idFrom = data.indexOf(idStr) + idStr.length();
            idTo = data.indexOf(nameStr);
            System.out.println(data.substring(idFrom, idTo));
            costFrom = data.indexOf(costStr) + costStr.length();
            costTo = data.indexOf(asleStr);
            System.out.println(data.substring(costFrom, costTo));
            data = data.substring(costTo + asleStr.length());
        }
    }
}