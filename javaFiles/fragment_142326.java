// using the classloader in instance context
getClass().getClassLoader().getResource("img0.png");
getClass().getClassLoader().getResource("fichierPointJava/img1.png");

// using the classloader in class/static context
<YourClass>.class.getClassLoader().getResource("img0.png");
<YourClass>.class.getClassLoader().getResource("fichierPointJava/img1.png");

// using the class in instance context
getClass().getResource("../img0.png");
getClass().getResource("/img0.png");
getClass().getResource("img1.png");
getClass().getResource("/fichierPointJava/img1.png");

// using the class in static/class context
<YourClass>.class.getResource("../img0.png");
<YourClass>.class.getResource("/img0.png");
<YourClass>.class.getResource("img1.png");
<YourClass>.class.getResource("/fichierPointJava/img1.png");