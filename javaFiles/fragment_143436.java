private List<String> populateAutoComplete(String path)
    {
        try
        {
            String content = readFile(path);
            Log.d(TAG,
                  "populateAutoComplete: " + content);
            List<String> listToPopulate = Arrays.asList(content.split("\\s*,\\s*"));
            return listToPopulate;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }