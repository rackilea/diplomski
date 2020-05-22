public class ParseUtils {

    @FunctionalInterface
    public interface Consumer { void accept(String s); }

    @FunctionalInterface
    public interface BiConsumer { void accept(String a, String b); }

    //... you can add TriConsumer etc. if you need to ...

    @FunctionalInterface  //conveniently parses integers
    public interface IntBiConsumer { void accept(int x, int y); }

    // implementations -----
    public static void parse(String src, String regex, Consumer callback) {
        callback.accept(parse(src, regex)[0]);
    }

    public static void parse(String src, String regex, BiConsumer callback) {
        String[] p = parse(src, regex);
        callback.accept(p[0],p[1]);
    }

    public static void parse(String src, String regex, 
                                                    IntBiConsumer callback) {
        String[] p = parse(src, regex);
        callback.accept(Integer.parseInt(p[0]), Integer.parseInt(p[1]));
    }

    public static String[] parse(String source, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(source);
        String[] ret = new String[m.groupCount()];
        if (m.matches()) {
            for (int i=0; i<m.groupCount(); i++) {
                ret[i] = m.group(1 + i);
            }
        }
        return ret;
    }

}