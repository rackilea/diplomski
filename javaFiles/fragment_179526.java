while (passedR == 0) {
...
            sTagR = JOptionPane.showInputDialog(...);
            if (sTagR == null) {
                 // User canceled.
                 break;
            } else {
               ...
            }
}