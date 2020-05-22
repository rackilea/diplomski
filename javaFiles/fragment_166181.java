// open directory that contains the files
File dir = new File("/your/folder/name");

// get the files with the timestamps between start and end
File[] files = dir.listFiles(new FilenameFilter() {

    @Override
    public boolean accept(File dir, String name) {
        // extract number from file name
        if (name.startsWith("Product.txt.")) {
            // divide by 10 to eliminate extra second (value is rounded as it's an int)
            // then multiply by 10 again to get timestamp of respective hour
            int timestamp = (Integer.parseInt(name.replace("Product.txt.", "")) / 10) * 10;
            System.out.println(timestamp);
            return start <= timestamp && timestamp <= end;
        }

        return false;
    }
});