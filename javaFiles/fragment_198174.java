public static void dumpHeap()

    {
        System.out.println("dumping data");

        String name = ManagementFactory.getRuntimeMXBean().getName();
        System.out.println("name :" + name);
        String pid = name.substring(0, name.indexOf("@"));
        System.out.println("pid :" + pid);

        String[] cmd = { "jmap", "-dump:file=/Users/MyName/Desktop/dump.bin", "-F", pid };
        Process p;
        try {
            p = Runtime.getRuntime().exec(cmd);
        } catch (IOException e) {
            e.printStackTrace();
        }