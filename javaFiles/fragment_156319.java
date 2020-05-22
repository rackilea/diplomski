public class NoClassp3 {

public static void main(String[] args) {
    int numberOfStrings = getNumberOfStrings();
    String[] stringName = new String[numberOfStrings];
    stringName = getStringName(stringName);

    for (int i = 0; i < stringName.length; i++)
    {
        System.out.println(stringName[i]);
    }
}   // end method main

public static int getNumberOfStrings() {
   String input = JOptionPane.showInputDialog("Enter number of strings in integer format");
   int number = Integer.parseInt(input);
   return number;
}   // end method getNumberOfStrings

public static String[] getStringName(String[] name) {
    for (int i = 0; i < name.length; i++)
        name[i] = JOptionPane.showInputDialog("Enter string name");
    return name;
}   // end method getStringName
}   // end class NoClassp3