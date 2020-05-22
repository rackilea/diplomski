File[] files = folder.listFiles(new FileFilter() {
        public boolean accept(File file) {
            try {
                String[] bounds = file.getName().toLowerCase().split("-");
                return (Integer.parseInt(bounds[0]) <= 10 && Integer.parseInt(bounds[1]) >= 1);
            } catch (Exception e) {
                // array index out of bounds & number format exceptions mean 
                // this isn't a directory with the proper name format
                return false;
            }
        }
    });
    System.out.println(Arrays.toString(files)); // 1-1, 2-3, 4-10