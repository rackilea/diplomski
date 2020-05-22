String cmd = System.getenv("windir") + "\\system32\\" + "chcp.com";
    Process p = Runtime.getRuntime().exec(cmd);
    // Use default charset here - only want digits which are "core UTF8/UTF16"; 
    // ignore text preceding ":"
    String windowsCodePage = new Scanner(
        new InputStreamReader(p.getInputStream())).skip(".*:").next();

    Charset charset = null;
    String[] charsetPrefixes = 
        new String[] {"","windows-","x-windows-","IBM","x-IBM"};
    for (String charsetPrefix : charsetPrefixes) {
        try {
            charset = Charset.forName(charsetPrefix+windowsCodePage);
            break;
        } catch (Throwable t) {
        }
    }
    // If no match found, use default charset
    if (charset == null) charset = Charset.defaultCharset();

    cmd = System.getenv("windir") + "\\system32\\" + "tasklist.exe";
    p = Runtime.getRuntime().exec(cmd);
    InputStreamReader isr = new InputStreamReader(p.getInputStream(), charset);
    BufferedReader input = new BufferedReader(isr);

    // Debugging output
    System.out.println("matched codepage "+windowsCodePage+" to charset name:"+
            charset.name()+" displayName:"+charset.displayName());
    String line;
    while ((line = input.readLine()) != null) {
           System.out.println(line);
    }