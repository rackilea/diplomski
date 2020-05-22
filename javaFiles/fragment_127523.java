//Method 1:
System.out.println( System.getProperty("user.dir"));
//Method 2:
System.out.println(new File("/").getAbsolutePath());   

//than use this to the path you want:
System.setProperty("user.dir", "/new/Path");