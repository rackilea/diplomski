class MyFileView extends FileView
{
Hashtable<String,ImageIcon> table;
ImageIcon dirIcon;

    public MyFileView(Hashtable<String,ImageIcon> table,ImageIcon dirIcon)
    {
        this.table=table;
        this.dirIcon=dirIcon;
    }

    public Icon getIcon(File f)
    {
    // Do display custom icons

        // If dir
        if(f.isDirectory()) 
        {
            if(dirIcon!=null) return dirIcon;
        return new ImageIcon("myfoldericon.png");
        }

        // Get the name
        String name=f.getName();
        int idx=name.lastIndexOf(".");

        if(idx>-1)
        {
        String ext=name.substring(idx);
            if(table.containsKey(ext))
        return table.get(ext);
        }

    // For other files
    return new ImageIcon("myownfileicon.png");
    }
}