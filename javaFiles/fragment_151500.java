public class SizableTable extends Table { 
    //... Constructors ...

    public Dimension getPreferredSize() {
        cvars = CVarList.getInstance();
        return new Dimension(cvars.get("Window", "width", int.class, 800),
            cvars.get("Window", "height", int.class, 600));
    }
}