public class CustomExtension extends FileFilter
{
    private String type;

    public CustomExtension(String type)
    {
        this.type = type;
    } 

    public Boolean accept(File file)
    {  
        if(file.isDirectory())
            return true;

        String ext = getExtension(file);
        if(ext == null)
            return false;

        switch(type)
        {
            case "battle":
                if(ext.equals("battle"))
                    return true;
                else 
                    break;
            default:
                System.out.println(type + " has not been set up in the switch statement yet");
        }

        return false;
    }

    public String getDescription()
    {
        switch(type)
        {
            case "battle":
                return "Only battle file supported";
        }
    }

    public String getExtension(File f)
    {
        String ext = null;
        String filename = f.getName();

        int i = filename.lastIndexOf('.');

        if(i > 0 && i < filename.length() - 1)
            ext = s.substring(i + 1).toLowerCase();

        return ext;
    }
}