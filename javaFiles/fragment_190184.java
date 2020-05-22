//replace filePath with the path to the folder where the class file is stored
    URLClassLoader classLoader = URLClassLoader.newInstance(new URL[]{filePath.toURI().toURL()});

    //this actually loads the class into java so you can use it
    Class<?> cs = Class.forName(compiledClassName, true, classLoader);

    //the getConstructor method will return the constructor based on the 
    //parameters that you pass in. The default constructor has none, but if 
    //you want a different constructor you just pass in the class of the 
    //object you want to use
    Constructor<?> ctor = cs.getConstructor();

    //you can then just create a new instance of your class
    Player player = (Player) ctor.newInstance();

    //You can then call any methods on the Player object that you want.
    player.MoveUp();