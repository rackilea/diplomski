public final class CmdLineArgs
{
    public static void main(final String... args)
    {
        final int len = args.length;

        System.out.println("---- Begin arguments ----");
        IntStream.range(0, len)
            .map(index -> String.format("Arg %d: %d", index + 1, args[index])
            .forEach(System.out::println);
        System.out.println("---- End arguments   ----");

        System.exit(0);
    }
}