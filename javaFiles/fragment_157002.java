import java.util.ArrayList;

public class PluginLoader
{
    public static void main(String args[])
    {
        new PluginLoader();
    }

    public PluginLoader()
    {
        Configuration configuration = new Configuration("Processed text from plugin: ");
        FileManager filemanager = new FileManager(configuration);
        ArrayList<Plugin> plugins = new ArrayList<>();

        Plugin plugin1 = new JavaPlugin();
        plugin1.setConfiguration(configuration);
        plugin1.setFileManager(filemanager);
        plugins.add(plugin1);

        Plugin plugin2 = new PhpPlugin();
        plugin2.setConfiguration(configuration);
        plugin2.setFileManager(filemanager);
        plugins.add(plugin2);

        for(Plugin plugin : plugins)
        {
            System.out.println(plugin.getOutputName());
        }       
    }

    public class JavaPlugin extends Plugin
    {
        public String getOutputName()
        {
            return getFileManager().getConfiguration().getText() + "JavaPlugin";
        }
    }

    public class PhpPlugin extends Plugin
    {
        public String getOutputName()
        {
            return getFileManager().getConfiguration().getText() + "PhpPlugin";
        }
    }

    public abstract class Plugin
    {
        private Configuration configuration;

        private FileManager filemanager;

        public abstract String getOutputName();

        public void setConfiguration(Configuration configuration)
        {
            if(this.configuration == null)
            {
                this.configuration = configuration;
            }
        }

        public void setFileManager(FileManager filemanager)
        {
            if(this.filemanager == null)
            {
                this.filemanager = filemanager;
            }
        }

        public Configuration getConfiguration()
        {
            return configuration;
        }

        public FileManager getFileManager()
        {
            return filemanager;
        }
    }

    public class FileManager
    {
        private final Configuration configuration;

        public FileManager(Configuration configuration)
        {
            this.configuration = configuration;
        }

        public Configuration getConfiguration()
        {
            return configuration;
        }
    }

    public class Configuration
    {
        private final String text;

        public Configuration(String text)
        {
            this.text = text;
        }

        public String getText()
        {
            return text;
        }
    }
}