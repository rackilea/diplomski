File dir = new File(path);
    File[] matchingFiles = dir.listFiles(new FileFilter() {
        @Override
        public boolean accept(File pathname) {
            String regex = "Acrobat \\d{1,2}\\.\\d";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(pathname.getName());
            return m.matches();
        }
    });
    for(File f : matchingFiles) {
        System.out.println(f.getName());
    }