public class FileNameNumericSort {

    private final static File[] files = {
        new File("Spectrum_1.txt"),
        new File("Spectrum_14.txt"),
        new File("Spectrum_2.txt"),
        new File("Spectrum_7.txt"),     
        new File("Spectrum_1000.txt"), 
        new File("Spectrum_999.txt"), 
        new File("Spectrum_9990.txt"), 
        new File("Spectrum_9991.txt"), 
    };

    @Test
    public void sortByNumber() {
        Arrays.sort(files, new Comparator<File>() {
            @Override
            public int compare(File o1, File o2) {
                int n1 = extractNumber(o1.getName());
                int n2 = extractNumber(o2.getName());
                return n1 - n2;
            }

            private int extractNumber(String name) {
                int i = 0;
                try {
                    int s = name.indexOf('_')+1;
                    int e = name.lastIndexOf('.');
                    String number = name.substring(s, e);
                    i = Integer.parseInt(number);
                } catch(Exception e) {
                    i = 0; // if filename does not match the format
                           // then default to 0
                }
                return i;
            }
        });

        for(File f : files) {
            System.out.println(f.getName());
        }
    }
}