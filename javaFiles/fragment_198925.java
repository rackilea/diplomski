public class FileFinder{

    public static List<File> findFiles(final File baseDir, final String regex){
        final List<File> files = new ArrayList<File>();

        scanFolder(baseDir, Pattern.compile(regex), files);
        return files;
    }

    private static void scanFolder(final File dir,
        final Pattern pattern,
        final List<File> files){

        for(final File candidate : dir.listFiles()){
            if(candidate.isDirectory()){
                scanFolder(candidate, pattern, files);
            } else if(pattern.matcher(candidate.getName()).matches()){
                files.add(candidate);
            }
        }
    }

}