public static void main(String[] args) {

        if (args.length >= 4) {
            String originalPdf = args[0];
            String targetPdf = args[1];
            Map<String, String> urls = new HashMap<String, String>();
            for(int i = 2; i< args.length; i+=2){
                urls.put(args[i], args[i+1]);
            }
            URLReplacer.changeURL(originalPdf, targetPdf, urls);
        } else {
            System.out.println("PARAMETER MISSING FROM PHP");
        }
    }