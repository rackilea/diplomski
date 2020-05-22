public class Example {
    static int count = 0; //Create a count
    static JLabel[] array = new JLabel[3]; //Create an array to hold all three JLabels

    public static void main(String[] args) {
        //Set the default text for each JLabel
        array[0] = new JLabel("This is OP1");
        array[1] = new JLabel("This is OP2");
        array[2] = new JLabel("This is OP3");
        //Here is an example if you wanted to use a for-loop to update the JLabels
        for (int x = 0; x < array.length; x++) {
            updateNextLabel("This is the new text for OP" + (count + 1));
            System.out.println(array[x].getText());
        }
    }

    public static void updateNextLabel(String str) {
        array[count].setText(str);
        count++;
    }
}