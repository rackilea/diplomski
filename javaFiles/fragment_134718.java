String getMyDocuments()
{
    String out = ".\\";
    try
    {
        Process process = Runtime.getRuntime().exec("reg query \"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders\" /v personal");
        process.waitFor();
        StringWriter sw = new StringWriter();
        int c;
        while ((c = process.getInputStream().read()) != -1)
        {
            sw.write(c);
        }
        String output = sw.toString().replaceAll("\t", "    ");
        String[] parsed = output.split("\\t|\\s{2,}");
    }
    catch (Exception e)
    {
        e.printStackTrace();
    }
    return out;
}