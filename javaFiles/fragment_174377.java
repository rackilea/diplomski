URLClassLoader application1Loader = new ClassLoader(/* URLs to common Jars and the config files for instance 1*/);
URLClassLoader application2Loader = new ClassLoader(/* URLs to common Jars and the config files for instance 2*/);

// Assuming you have a wrapper for your application that you can run() to get it going
// in its own thread via reflection.

Class<? extends Runnable> app1Class = application1Loader.loadClass("my.pkg.MyApplicaion")
    .asSubclass(Runnable.class);
// newInstance() is problematic but I want this code to be brief.
app1Class.newInstance().run();

Class<? extends Runnable> app2Class = application2Loader.loadClass("my.pkg.MyApplicaion")
    .asSubclass(Runnable.class);
app2Class.newInstance().run();