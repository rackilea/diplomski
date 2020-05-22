//Get the file by name
File file = new File(p.getDataFolder(), "myCustomConfigFile.yml");
YamlConfiguration config = null;

//if the file doesn't exist...
if(!file.exists()){
    try{
       //create the new config file
       file.createNewFile();

       //get the custom config YamlConfiguration
       config = YamlConfiguration.loadConfiguration(badwordsfile);
       config.options().copyDefaults(true);

       //set default values in the config
       config.set("Bad Words", "Stupid, Shut Up, Poop");
       config.set("Punishment", "kick %player% don't say that"

       //save the YAMLConfiguration
       try{config.save(file);}
       catch(Exception ex){ex.printStackTrace();}
    }
    catch(Exception ex){ex.printStackTrace();}
}
else{
    //otherwise, set the config to the current file
    config = YamlConfiguration.loadConfiguration(file);
}