public class test {
  public static void main(String args[]) {
   int height = 3;
   int width = 6;
   int numberOfBoxes = 4;
   StringBuilder output = new StringBuilder();
   // height + 2 for the extra row of characters on the top and bottom
   for(int h = 0; h < height + 2; h++ ){
        for(int box = 0; box < numberOfBoxes; box++ ){
            // If on the outer edge, when h = 0 or h = height + 1
            if (h % (height + 1) == 0) {
                output.append("+");
                for (int w = 1; w <= width; w++){ 
                        output.append("-");
                    }
            // Otherwise only draw the vertical lines.
            } else {
                output.append("|");
                for (int w = 1; w <= width; w++){ 
                        output.append(" ");
                    }
            }
        }
        // Add the last line of characters
        if (h % (height + 1) == 0) {
            output.append("+");
        } else {
            output.append("|");
        }
        // Add new line character
        output.append("\n");
   }
   System.out.println(output.toString());
  }
}