File f = new File("/home/myfiles");

File [] files = f.listFiles();

Arrays.sort( files, new Comparator()
{
    public int compare(Object o1, Object o2) {

        if (((File)o1).lastModified() > ((File)o2).lastModified()) {
            return -1;
        } else if (((File)o1).lastModified() < ((File)o2).lastModified()) {
            return +1;
        } else {
            return 0;
        }
    }

});