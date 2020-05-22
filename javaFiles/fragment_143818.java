/**
 * Main Class
 */
public class ColorChooser {
   ...
   public ColorChooser() {
      ...
      DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
      JComboBox combobox = new JComboBox<String>(model);
      combobox.setEditable(false);
      cobobox.setRenderer(new ComboRenderer());
      ...
   }
   ...
}

/**
 * Renderer Class
 */
public class ComboRenderer extends JLabel implements ListCellRenderer<Object> {

   public ComboRenderer() {

   }

   public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {

      setFont(newFont("Consolas", Font.PLAIN, 14));
      setOpaque(true);

      String hex;

      if (value != null) {

         /*
          * So basically I add to my 'model' in ColorChooser main class only Strings
          * which I get e.g. from some JTextField. 
          * On base of this String I create icon for future JLabel
          * and I set String 'value' as text for it.
          */
         hex = value.toString();

         Color color = HexToRgb(hex); //Method which translates String to Color

         ColorSwatch icon = new ColorSwatch(10, true); // ColorSwatch is a method which creates specific square icon (in this case a little square)
         icon.setColor(color);

         setText(hex);
         setIcon(icon);
      }
      return this;
   }

   /*
    * My translate method which translates given String to a specific color value
    * (RGB/RGBA)
    */
   public Color HexToRgb(String colorStr) {

      Color color = null;

      // For String hex value '#RRGGBB'
      if (colorStr.length() == 7) {

         color = new Color(
            Integer.valueOf(colorStr.substring(1, 3), 16),
            Integer.valueOf(colorStr.substring(3, 5), 16),
            Integer.valueOf(colorStr.substring(5, 7), 16));

        // For String hex value '#AARRGGBB'
      } else if (colorStr.length() == 9) {

         color = new Color(
            Integer.valueOf(colorStr.substring(3, 5), 16),
            Integer.valueOf(colorStr.substring(5, 7), 16),
            Integer.valueOf(colorStr.substring(7, 9), 16),
            Integer.valueOf(colorStr.substring(1, 3), 16));

        // For String hex value '0xRRGGBB'
      } else if (colorStr.length() == 8) {

         color = new Color(
            Integer.valueOf(colorStr.substring(2, 4), 16),
            Integer.valueOf(colorStr.substring(4, 6), 16),
            Integer.valueOf(colorStr.substring(6, 8), 16));

        // For String hex value '0xAARRGGBB'
      } else if (colorStr.length() == 10) {

         color = new Color(
            Integer.valueOf(colorStr.substring(4, 6), 16),
            Integer.valueOf(colorStr.substring(6, 8), 16),
            Integer.valueOf(colorStr.substring(8, 10), 16),
            Integer.valueOf(colorStr.substring(2, 4), 16));

      } else
         JOptionPane.showMessageDialog(null, "Something wen wrong... :|");

      return color;
   }
}