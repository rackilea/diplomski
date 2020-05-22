public abstract class GenericMapFactory<T>
{
    public Map<String,T> makeMap(File in) throws InstantiationException, IllegalAccessException, IOException
    {
        Map<String,T> result = new HashMap<String,T>();
        BufferedReader rdr = new BufferedReader(new FileReader(in));
        String line = null;
        while ((line=rdr.readLine()) != null)
        {
            String key  = "" /* something meaningful for your application */; 
            T      item = parse(line);
            result.put(key, item);
        }
        return result;
    }

    protected abstract T parse(String line);
}