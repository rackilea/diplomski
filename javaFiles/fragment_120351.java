public class Main {

    public static void main(String[] args) {
        String fullStr = "first:center:last";
        int firstColonIndex = fullStr.indexOf(':');
        int secondColonIndex = fullStr.indexOf(':', firstColonIndex + 1);
        String centerStr = fullStr.substring(firstColonIndex + 1, secondColonIndex);
        System.out.println("centerStr = " + centerStr);
    }
}