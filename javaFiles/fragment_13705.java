File fXmlFile = new File("F:\\Test.hbm.xml");
        FileInputStream fis = new FileInputStream(fXmlFile);
        String fileContent = "";
        while(fis.available() > 0){
            fileContent += (char)fis.read();
        }
        String[] lines = fileContent.split("\n");
        for (String string : lines) {
            string = string.trim();
            String value="";
            if(string.startsWith("<")){
                if(string.indexOf(" ") == -1)
                    value = string;
                else
                    value = string.substring(0, string.indexOf(" "));
            }
            value = value.replace("<", "").replace(">", "");
            System.out.println(value);
        }