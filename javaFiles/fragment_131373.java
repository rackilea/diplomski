public static void main(String[] args) throws Exception {

    Map<String, File> map = getFiles(new File("."));

    for (String name : map.keySet())
        if (name.endsWith(".txt")) // display filter
            System.out.println(name + " ---> " + map.get(name));
}

private static Map<String, File> getFiles(File current) {

    Map<String, File> map = new HashMap<String, File>();

    if (current.isDirectory()) { 
        for (File file : current.listFiles()) {
            map.put(file.getName(), current);
            map.putAll(getFiles(file));
        }
    }

    return map;
}