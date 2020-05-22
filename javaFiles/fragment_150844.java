class SoundURL {

    public static void main(String[] args) throws Exception {
        // let us assume you are able to trim it down to this..
        String script = "playV2('en/US/dg/dgsysksfdyht')";

        String prefix = "http://img2.tfd.com/pron/mp3/";
        String suffix = ".mp3";

        int start = script.indexOf("'");
        int end = script.indexOf("'", start+1);

        String path = script.substring(start+1,end);
        String urlString = prefix + path + suffix;

        System.out.println(urlString);
    }
}