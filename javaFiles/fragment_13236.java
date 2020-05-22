public static void main(String[] args)
{
    for (String w : "camelValue".split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
        System.out.println(w);
    }
}