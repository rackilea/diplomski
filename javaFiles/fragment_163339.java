//adds a new keyword to customers properties
    public String setKeyWords(String customer, String word){
        try{
                PropertiesConfiguration props = new PropertiesConfiguration("/home/mikhail/bzrrep/DLP/DLPServer/src/main/resources/rules.properties");
                String newKeyWord = new String(props.getString("users." + customer + ".keywords") + "," + word);
                props.setProperty("users." + customer + ".keywords", newKeyWord);
                props.save();
        }catch (ConfigurationException e){
            e.printStackTrace();
        }
        return "keyword " + word + " added";
    }

    // adds a new regexp to customer properties
    public String setRegExp(String customer, String regexp){
        try {
                PropertiesConfiguration props = new PropertiesConfiguration("/home/mikhail/bzrrep/DLP/DLPServer/src/main/resources/rules.properties");
                String newRegValue = new String(props.getString("users." + customer + ".regexps") + "," + regexp);
                props.setProperty("users." + customer + ".regexps", newRegValue);
                props.save();
        } catch (ConfigurationException e){
            e.printStackTrace();
        }
        return "regexp " + regexp + " added to " + customer + "'s config";
    }