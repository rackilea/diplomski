class TimeCalculator{

    public static void main(String[] args) {
        double seconds;
        String input;

        input = JOptionPane.showInputDialog("Enter any number of seconds");

        seconds = Double.parseDouble(input);

        if (seconds >= 60)
            JOptionPane.showMessageDialog(null, "There are " + (seconds / 60) + " minutes in " + seconds + " seconds.");

        if (seconds >= 3600)
            JOptionPane.showMessageDialog(null, "There are " + (seconds / 3600) + " hours in " + seconds + " seconds.");

        if (seconds >= 86400)
            JOptionPane.showMessageDialog(null,
                    "There are " + (seconds / 86400) + " days in " + seconds + " seconds.");
        System.exit(0);
    }
}