try (InputStream input=getClass().getClassLoader().getResourceAsStream("plugins.xml")){
    try(Reader reader=new InputStreamReader(input));
    {
        Xpp3Dom Xpp3DomObject = Xpp3DomBuilder.build(input);
    } catch (Exception e) {
        ...
    }
}