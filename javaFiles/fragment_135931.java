public boolean urlEquals(Lab lab, String other){
    try{
        Field browsersField = Lab.class.getDeclaredField("browsers");
        Object browsers = browsersField.get(lab);

        Object browser = Array.get(browsers, 3);

        Field urlField = Browser.class.getDeclaredField("url");
        urlField.setAccessible(true);
        Object url = urlField.get(browser);

        return url.equals(other);
    } catch(Exception e){ // probably catch specific exceptions than all
        throw new IllegalStateException(e);
    }
}