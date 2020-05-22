public class Rec {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Please enter a regular expression: ");
        String regex = in.next();

        Pattern p = Pattern.compile(regex);

        new Rec (p).start (".");
    }

    private Pattern p;

    Rec (Pattern pP)
    {
       p = pP;
    }

    void start (String pDir) {
        File dir = new File (pDir);

        File[] files = dir.listFiles();
        if (files == null) return;
        for (int i = 0; i < files.length; i++) {
            String x = files[i].toString();
            if (".".equals(x)) continue;
            if ("..".equals(x)) continue;

            Matcher m = p.matcher(x);
            if (m.matches()) {
                System.out.println(x);
            }
            if (files[i].isDirectory ()) {
               start (pDir+File.separator + x);
            }
        }
    }