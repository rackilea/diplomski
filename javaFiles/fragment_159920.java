public static void main(String[] args) {

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    Date date = new Date();
    String ts = dateFormat.format(date);

    File source = new File("D:\\A1\\");
    File dest = new File("D:\\A2\\");

    for (File file : source.listFiles()) {
        String x = (source + "\\" + file.getName());
        String y = (dest + "\\" + addTimestamp(file.getName(), ts));

        File f1 = new File(x);
        if(f1.renameTo(new File(y))){
            System.out.println("moved: " + y);
        } else {
            System.out.println("unable to move: " + y);
        }
    }
}

private static String addTimestamp(String name, String ts) {
    int lastIndexOf = name.lastIndexOf('.');
    return (lastIndexOf == -1 ? 
            name + "_" + ts 
            : 
            name.substring(0, lastIndexOf) + "_" + ts + 
            name.substring(lastIndexOf))
             .replaceAll("[\\/:\\*\\?\"<>| ]", "_");
}