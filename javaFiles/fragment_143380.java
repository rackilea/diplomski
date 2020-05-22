public class MyResources extends ListResourceBundle {
     protected Object[][] getContents() {
         return new Object[][] = {
         // LOCALIZE THIS
             {"s1", "The disk \"{1}\" contains {0}."},  // MessageFormat pattern
             {"s2", "1"},                               // location of {0} in pattern
             {"s3", "My Disk"},                         // sample disk name
             {"s4", "no files"},                        // first ChoiceFormat choice
             {"s5", "one file"},                        // second ChoiceFormat choice
             {"s6", "{0,number} files"},                // third ChoiceFormat choice
             {"s7", "3 Mar 96"},                        // sample date
             {"s8", new Dimension(1,5)}                 // real object, not just string
         // END OF MATERIAL TO LOCALIZE
         };
     }
 }