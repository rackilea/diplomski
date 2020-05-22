import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class DatabaseConstantsAccessor
{
    // don't include .properties extension, just specify the name without extension
    private static final String BUNDLE_NAME = "database";

    private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private ConstantsAccessor()
    {
    }

    public static String getString(String key)
    {
        try
        {
            return RESOURCE_BUNDLE.getString(key);
        }
        catch (MissingResourceException e)
        {
            return '!' + key + '!';
        }
    }
}