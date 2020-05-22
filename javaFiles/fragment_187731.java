File file = new File("base_ch.properties");
    PropertiesConfigurationExtended config = new PropertiesConfigurationExtended();
    PropertiesConfigurationLayoutExtended layout = new PropertiesConfigurationLayoutExtended(config);

    try(InputStreamReader in = new InputStreamReader(new FileInputStream(file), "UTF-8"))
    {
        layout.load(in);    
        OutputStreamWriter out =new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        config.setProperty("key","アカウント ナビゲーション コンポーネント");
        layout.save(out, false));       
    }
    catch (ConfigurationException | IOException e) {
        e.printStackTrace();
    }