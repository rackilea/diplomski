public class MenuScreen extends MainScreen {
   private Background _menuBackground;
   private Border _menuBorder;
   private Font _menuFont;
   private MenuItem _customMenuItems[];

   public MenuScreen() {
      setTitle("Custom Menu Sample");
      getMainManager().setBackground(BackgroundFactory.createSolidBackground(Color.BLACK));

      RichTextField f = new RichTextField("Creating a custom menu") {                   

         protected void paint(Graphics g) {
            int oldColor = g.getColor();
            g.setColor(Color.WHITE);
            super.paint(g);
            g.setColor(oldColor);
         }
      };
      add(f);

      // Customize the look (border/color/font) of the BB menu here:
      XYEdges thickPadding = new XYEdges(10, 10, 10, 10);
      _menuBorder = BorderFactory.createRoundedBorder(thickPadding, Border.STYLE_DOTTED);        
      _menuBackground = BackgroundFactory.createSolidTransparentBackground(Color.DARKMAGENTA, 80);

      try
      {
         FontFamily family = FontFamily.forName("BBCasual");
         _menuFont = family.getFont(Font.PLAIN, 30, Ui.UNITS_px);
      }
      catch (final ClassNotFoundException cnfe)
      {
         UiApplication.getUiApplication().invokeLater(new Runnable()
         {
            public void run()
            {
               Dialog.alert("FontFamily.forName() threw " + cnfe.toString());
            }
         });              
      }       

      // Add our own menu items, too
      _customMenuItems = new MenuItem[3];
      _customMenuItems[0] = new MenuItem("Hola Dora!", 110, 10) {
         public void run() {
            Dialog.inform("Hola Dora!");
         }
      };
      _customMenuItems[1] = new MenuItem("Close popup!", 111, 10) {
         public void run() {
            Dialog.inform("Close popup!");
         }
      };
      _customMenuItems[2] = new MenuItem("Hola Diego!", 112, 10) {
         public void run() {
            Dialog.inform("Hola Diego!");
         }
      };

      addMenuItem(_customMenuItems[0]);
      addMenuItem(_customMenuItems[1]);
      addMenuItem(_customMenuItems[2]);      
   }

   protected void makeMenu(Menu menu, int context)
   {
      menu.setBorder(_menuBorder);
      menu.setBackground(_menuBackground);
      menu.setFont(_menuFont);
      // invoking super.makeMenu() will add {Close, Switch Application, etc.} items
      super.makeMenu(menu, context);
   }
}