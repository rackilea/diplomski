public class S1166 {

    public static Integer parse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            LogUtils.log(e);
            return null;
        }
    }
}