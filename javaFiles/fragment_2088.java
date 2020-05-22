Map<String, String> configMap = new HashMap<String, String();

configMap.put(Constants.FRAMEWORK_SYSTEMPACKAGES,
    "your.package;other.package;org.osgi.framework");

// setup other properties

Bundle systemBundle = new Felix(configMap, null);
systemBundle.start();

// Now you can use classes from "your.package" with explicity 
// declaring them as imports in bundles