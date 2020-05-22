public static String filter(String text, Function<String,String>... filters) 
{
    for (Function<String,String> f : filters)
        text = f.apply(text);
    return text;
}