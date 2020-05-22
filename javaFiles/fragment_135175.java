public class UniqueNumbers {
  public static void main(String[] args) {
    args = new String[6];
    args[0] = "5";
    args[1] = "6";
    args[2] = "2";
    args[3] = "5";
    args[4] = "1";
    args[5] = "1";

    Arrays.sort(args); 
   // Sort the array. This will use natural order:
   // low -> high for integers, a -> z and low to high for strings
   // Essentially this causes our array to sort from low to high, despite not being integers

    for (int i = 0; i < args.length; i++) { // Loop over the entire array
        if (i == 0) { // (1)
            System.out.println(args[0]);
        } else if (!(args[i - 1].equals(args[i]))) { // (2)
            System.out.println(args[i]);
        }
    }
  }
}