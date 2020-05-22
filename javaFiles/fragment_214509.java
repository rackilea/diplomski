public LevelManager(Context context)
    {
        Serializer serializer = new Persister();
        Levels levels = null;
        BufferedReader br = null;

        try
        {
            br = new BufferedReader(new InputStreamReader(context.getResources().openRawResource(R.raw.levels)));
            levels = serializer.read(Levels.class, br);
        }
        catch (Exception e)
        {
            Log.e(getClass().getSimpleName(), "Error in deserialization.", e);
            throw new RuntimeException(e);
        }
        finally
        {
            if (br != null)
            {
                IOUtils.closeQuietly(br);
            }
        }