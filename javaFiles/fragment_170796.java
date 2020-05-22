// The image is located in default package of the classpath
Image image1 = new Image("/flower.png");

// The image is located in my.res package of the classpath
Image image2 = new Image("my/res/flower.png");

// The image is downloaded from the supplied URL through http protocol
Image image3 = new Image("http://sample.com/res/flower.png");

// The image is located in the current working directory
Image image4 = new Image("file:flower.png");