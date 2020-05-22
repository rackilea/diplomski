public class ResourceManager {

    private final Context context;
    private final Resources resources;
    private static ResourceManager resourceManager;

    private ResourceManager(Context context) {
        this.context = context;
        this.resources = context.getResources();
    }

    public static ResourceManager getResourceManager(Context context) {
        if (resourceManager == null) {
            resourceManager = new ResourceManager(context);
        }

        return resourceManager;
    }

    public String getJSONFromRawResources(String jsonFilename) {
        int resourceID = resources.getIdentifier(jsonFilename, "raw", context.getPackageName());

        InputStream inputStream = resources.openRawResource(resourceID);
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder jsonStringStringBuilder = new StringBuilder();

            String line;
            while ((line = reader.readLine()) != null) {
                jsonStringStringBuilder.append(line);
            }

            return jsonStringStringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}