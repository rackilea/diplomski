Class<?> load = ClassLoader.getSystemClassLoader().loadClass("com.Hello");
//Assume Hello class is in "com" package 
        load.newInstance().toString();
        URL[] urls = { load.getProtectionDomain().getCodeSource().getLocation() };
        ClassLoader delegateParent = load.getClassLoader().getParent();
        try (URLClassLoader cl = new URLClassLoader(urls, delegateParent)) {
            Class<?> reloaded = cl.loadClass(load.getName());
            reloaded.newInstance().toString();              
            }
            }
        }