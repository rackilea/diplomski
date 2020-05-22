private static String gg = null;

public static File lookup(File file, String name) {
    gg = null;
    return new File(lookupFile(file, name));
}

private static String lookupFile(File file, String name) {
    File[] list = file.listFiles();
    if(list != null) {
        for (File fil : list) {
            String n = fil.getName().replace(name, "");
            if (n.length() != 0) {
                if(fil.isDirectory())
                    lookupFile(fil , name);
            } else if (n.length() == 0) {
                String g = fil.toPath().toString();
                System.out.println(fil.getName());
                System.out.println(g);
                gg = g;
                return gg;
            }
        }
    }
    return gg;
}