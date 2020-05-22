public static Map<String, String> readValuesFromFile(final File f)
    throws IOException{

    final Splitter splitter =
        Splitter.on(':').trimResults().omitEmptyStrings();

    final Map<String, String> map = Maps.newHashMap();

    for(final String line : 

        Lists.transform(
            Files.readLines(f, Charsets.UTF_8),
            new Function<String, String>(){

                @Override
                public String apply(final String input){
                    return input != null && input.startsWith("> ")
                        ? input.substring(2)
                        : input;
                }

    })){

        if(line.startsWith("---")){
            break;
        }
        final String[] items =
            Iterables.toArray(splitter.split(line), String.class);
        if(items.length == 2 && !items[1].startsWith("=20")){
            map.put(items[0], items[1]);
        }
    }
    return map;
}