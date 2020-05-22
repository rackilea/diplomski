//DELETE THIS LINE - private static Map<String, String> codeMap = new HashMap<String, String>();

public static Map<String, String> readCodeFile(String fileName) throws  IOException {
    //Create a new map instead of reusing the static (shared) one
    Map<String, String> codeMap = new HashMap<String, String>();
        ...