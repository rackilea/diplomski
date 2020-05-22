public class MyConfigFactory

    public MyConfig createMyConfig(String configFile) throws IOException, SAXException
    {
        Digester digester = new Digester();
        digester.setValidating(false);

        digester.addObjectCreate("MyConfig", MyConfig.class);

        digester.addCallMethod("MyConfig/ServerName", "setServerName", 0);
        digester.addCallMethod("MyConfig/ServerPort", "setServerPort", 0);

        MyConfig mc = (MyConfig) digester.parse(new File(configFile));

        return mc;
    }

}