/** The data representation of one row in our table */
   private class Data {
      public String title;
      public String footer;
      public String[] text;  // each array element is a line of text
      public Bitmap icon;

      public Data(String title, String footer, String[] text, String iconName) {
         this.title = title;
         this.footer = footer;
         this.text = text;
         this.icon = Bitmap.getBitmapResource(iconName);
      }
   }