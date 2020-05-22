public class Program {
    public static void main(String... args) {
        Map<String, Object> opts = new HashMap<>();
        opts.put(Library.OPTION_FUNCTION_MAPPER, new FunctionNameAnnotationMapper());

        Obfuscated lib = Native.loadLibrary("my-library", Obfuscated.class, opts);
        lib.obfuscated1(0, null);
    }
}

interface Obfuscated extends Library {
    @NativeFunctionName(name = "main")
    public int obfuscated1(int argc, Pointer argv);
}