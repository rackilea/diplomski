import com.stakoverflow.plugin.MyPluginClass;

public class Main {

    public static void main(String[] args) {
        String myclass = "com.stakoverflow.plugin.MyPluginClass";
        try {
            Class clazz = Class.forName(myclass);

                MyPluginClass myPlugin = (MyPluginClass) clazz.newInstance();
                myPlugin.helloWorld();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}