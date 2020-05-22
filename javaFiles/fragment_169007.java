String urlString = ClassLoader.getSystemClassLoader().getResource("com/my/package/MyClass.class").toString();

urlString = urlString.substring(urlString.indexOf("file:"), urlString.indexOf('!'));
URL url = new URL(urlString);
File file = new File(url.toURI());
System.out.println(file);
System.out.println(file.exists());