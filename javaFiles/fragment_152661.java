FilenameFilter filter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.startsWith("cred");
            }
        };

        List<FileOrder> list = new ArrayList<FileOrder>();
        File dir = new File("/tmp/");
        for (File file : dir.listFiles(filter)) {
            list.add(new FileOrder(file.getName(), file.lastModified()));
        }

        Collections.sort(list);

        System.out.println(list);
        System.out.println("Last updated file : " + (list != null ? list.get(0) : null));