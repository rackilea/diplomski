try {    

    String jarName = new File(Insantiator.class.getProtectionDomain()    
                                                            .getCodeSource()    
                                                            .getLocation()    
                                                            .getPath())    
                                                            .getName();    
    JarFile jar = new JarFile(jarName);    
    Enumeration<JarEntry> entries = jar.entries();    
    while(entries.hasMoreElements()) {    
        ZipEntry entry = entries.nextElement();    
        String name = entry.getName();    
        if(name.contains("package/instances") && !name.contains("GenericInstance.class") && name.contains(".class")) {    
            name = name.replace("/", ".").replace(".class", "");    
            try {    
                Class theClass = Class.forName(name);    
                GenericInstance instance = (GenericInstance ) theClass.newInstance();    
                instances.add(instance);    
            } catch(InstantiationException | IllegalAccessException | ClassNotFoundException e) {    
                Utilities.writeLog("---- tried: " + name);    
                Utilities.writeLogException(null, e);    
            }    
        }    
    }        

} catch (IOException e) {    
    Utilities.writeLogException(null, e);    
}