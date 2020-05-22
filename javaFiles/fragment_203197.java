String[] commands = {"ruby","D:/MyProject/myruby.rb"};

Runtime rt = Runtime.getRuntime();

Process proc;
try
{
    proc = rt.exec(commands);
    BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
    String s;

    while ((s = stdInput.readLine()) != null) 
    {
        System.out.println(s);
    }
}
catch (IOException e)
{
    e.printStackTrace();
}