public class testing {
  public static void main(String args[]) {
     int height = 3;
     int width = 6;
     int numberOfBoxes = 4;
     String output = "";
     // height + 2 for the extra row of characters on the top and bottom
     for(int h = 0; h < height + 2; h++ ){
          for(int box = 0; box < numberOfBoxes; box++ ){
              // If on the outer edge, when h = 0 or h = height + 1
              if (h % (height + 1) == 0) {
                  output += "+";
                  for (int w = 1; w <= width; w++){ 
                          output += "-";
                      }
              // Otherwise only draw the vertical lines.
              } else {
                  output += "|";
                  for (int w = 1; w <= width; w++){ 
                          output += " ";
                      }
              }
        }
        // Add the last line of characters
        if (h % (height + 1) == 0) {
            output += "+";
        } else {
            output += "|";
        }
        // Add new line character
        output += "\n";
     }
     System.out.println(output);
  }
}