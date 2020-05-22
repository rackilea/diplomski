YamlConfiguration config = new YamlConfiguration();
File[] files = this.getDataFolder().listFiles();
for(File file : files){
    try {
        config.load(file);
        if(config.contains("Path")){
            //What you need to do.
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (InvalidConfigurationException e) {
        e.printStackTrace();
    }
}