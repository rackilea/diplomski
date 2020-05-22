private static final String BUNDLE_NAME = "com.testApp.resources.properties.Usability";

private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    public static Font getFont(String key){
        Font value = null;
        try {
            String fontName = (String) RESOURCE_BUNDLE.getString(key+ ".Name");
            Integer fontStyle = Integer.parseInt(RESOURCE_BUNDLE.getString(key+ ".Style"));
            Integer fontSize = Integer.parseInt(RESOURCE_BUNDLE.getString(key+ ".Size"));
            value = new Font(fontName, fontStyle, fontSize);
        } catch (MissingResourceException e) {
            value = new Font("Tahoma", Font.PLAIN, 11);
        }catch (NullPointerException npe) {
            value = new Font("Tahoma", Font.PLAIN, 11);
        }
        return value;
    }

    public static Color getColor(String key){
        Color value = null;
        try {
            Integer R = Integer.parseInt(RESOURCE_BUNDLE.getString(key+ ".R"));
            Integer G = Integer.parseInt(RESOURCE_BUNDLE.getString(key+ ".G"));
            Integer B = Integer.parseInt(RESOURCE_BUNDLE.getString(key+ ".B"));
            value = new Color(R, G, B);
        } catch (MissingResourceException e) {
//            value = new Color("Tahoma", Font.PLAIN, 11);
        }catch (NullPointerException npe) {
//          value = new Color("Tahoma", Font.PLAIN, 11);
        }
        return value;
    }

 public static Dimension getDimension(String key){
        Dimension value = null;
        try {
            Integer X = Integer.parseInt(RESOURCE_BUNDLE.getString(key+ ".X"));
            Integer Y = Integer.parseInt(RESOURCE_BUNDLE.getString(key+ ".Y"));
            value = new Dimension(X, Y);
        } catch (MissingResourceException e) {
//            value = new Color("Tahoma", Font.PLAIN, 11);
        }catch (NullPointerException npe) {
//          value = new Color("Tahoma", Font.PLAIN, 11);
        }
        return value;
    }
}