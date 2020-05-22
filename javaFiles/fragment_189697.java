int reply1 = JOptionPane.showOptionDialog(null,
   "Text explaining which option to choose\n",
   "Title",
   JOptionPane.YES_NO_OPTION,
   JOptionPane.PLAIN_MESSAGE,
   null,
   option,
   option[0]);

   if (reply1 == JOptionPane.YES_OPTION) {
      // option 1
   } else if (reply1 == JOptionPane.NO_OPTION) {
      // option 2
   }