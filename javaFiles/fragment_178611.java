for (int i = 0; i < dirs.size(); i++) {
        List<File> files = dirs.get(i).listFiles();
        for (File file : files) {
            if (checkCondition(file)) {
                fileList.add(file);
            }
            if (file.isDirectory()) {
                dirs.add(file);
            }
        }
    }