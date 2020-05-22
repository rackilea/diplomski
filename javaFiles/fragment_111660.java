// Load path of the Image from Properties file
        Properties properties = new Properties();
        properties.load(this.getClass().getResourceAsStream(
                "/resource.properties"));
        // To get the Path of the Context
        String contextPath = request.getContextPath();
        String split_path[] = contextPath.split("/");
        contextPath = request.getRealPath(split_path[0]);
        Image image = Image.getInstance(contextPath
                    + properties.getProperty("logoPath"));
        image.scaleAbsolute(120f, 60f);// image width,height