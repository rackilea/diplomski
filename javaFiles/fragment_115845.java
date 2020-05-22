public class Test {

    public static void main(String[] args) {

        String[] strs = { "first", "second", "last" };
        String[] tags = { "title", "author", "something" };

        for (int i = 0; i < strs.length; i++)
            strs[i] = String.format("<%s>%s</%1$s>", tags[i], strs[i]);

        String result = "";
        for (String str : strs)
            result += str;

        System.out.println(result);
    }
}