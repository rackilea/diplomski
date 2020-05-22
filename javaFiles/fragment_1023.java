Enumeration<URL> en =  this.getClass().getClassLoader().getResources("spring/label.properties");
     while(en.hasMoreElements()){
        URL url = en.nextElement();
        //Print all path to visualize the path
        System.out.println(url.getPath());
        if(url.getPath().contains("my-jar")){ // This can be jar name
            BufferedReader reader = new BufferedReader(new InputStreamReader(en.nextElement().openStream()));
            String str = null;
            while((str = reader.readLine())!=null){
                // Now you can do anything with the content.
                System.out.println(str);
            }
        }
    }