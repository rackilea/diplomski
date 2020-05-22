public static void main(String... args)
{
    int i = args.length;

    final int finalI = i;
    class Inner {
        void dumpit() {
            System.out.println(finalI);
        }
    }
    new Inner().dumpit();
}