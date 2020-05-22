//Custom Renderer - does the default rendering except if told the row should be a different color
public static class CustomRenderer extends DefaultTableCellRenderer{

    public CustomRenderer(){
        super();
        //Customize the rendering however you want
        setBackground(UIManager.getColor("TableHeader.background"));
    }
}