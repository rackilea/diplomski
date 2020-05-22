public class GregsFunkyClass {

    private static final Map<String,Boolean> validOptions = new HashMap<>();
    static {
        validOptions.put("yes", true);
        validOptions.put("y", true);
        validOptions.put("no", false);
        validOptions.put("n", false);
    }

    private boolean shouldEnterMoreData() {
        while (true) {
            String input = JOptionPane.showInputDialog("Would you like to enter another salespersons' data?");
            boolean toReturn = validOptions.get(input.trim().toLowerCase());
            if (toReturn != null) {
                return toReturn;
            }
            System.out.println("Not a valid option");
        } 
    }
}