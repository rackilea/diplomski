public static void main(String[] a)
{
    Set<String> styles = getAvailableStyles("Arial");
    System.out.println(styles);
}

public static Set<String> getAvailableStyles(String name)
{
    Set<String> styles = new HashSet<String>();
    GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
    Font[] fonts = e.getAllFonts();
    for (Font f : fonts)
    {
        if (f.getFamily().equals(name))
            styles.add(f.getName());
    }
    return styles;
}