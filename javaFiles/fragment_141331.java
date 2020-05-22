public static void main(String[] args) {
    Class<ObfuscateMe> obfuscateMeClass = ObfuscateMe.class;
    System.out.println("Class name: `" + obfuscateMeClass + "`");
    try {
        System.out.println("Class.forName: " + Class.forName(obfuscateMeClass.getName()));
    }
    catch (ClassNotFoundException exception) { System.out.println("Can't find class using Class.forName: `" + obfuscateMeClass.getName() + "`"); }
    try {
        System.out.println("ClassLoader.loadClass: " + Main.class.getClassLoader().loadClass(obfuscateMeClass.getName()));
    }
    catch (ClassNotFoundException exception) { System.out.println("Can't find class using ClassLoader.loadClass: `" + obfuscateMeClass.getName() + "`"); }
}