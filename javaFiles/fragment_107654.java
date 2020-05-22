File file = new File("C:/Users/Robert/Documents/workspace/project/resources/dynamicFolderNonInClassPath");
if (!file.exists()) System.out.println("typo!"); //debug print
URL url = new URL("C:/Users/Robert/Documents/workspace/project/resources/dynamicFolderNonInClassPath/");
URLClassLoader loader = new URLClassLoader(new URL[]{url});
String classToBeLoaded = "loadThis.LoadAClass";

Class classy = loader.loadClass(classToBeLoaded);
System.out.println(classy.getCanonicalName()); //debug print