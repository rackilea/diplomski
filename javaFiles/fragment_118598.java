public static void lineNumber (String inputString)
{
    int count = 1;

    String[] lines = inputString.split("\\r?\\n");
    for (String line : lines) {
        System.out.println("line " + count++);
        int n = line.length();
        for (int i = 0; i < n; i++)
        {
            char ch = line.charAt(i);
            getOP(ch);

        }
    }
}