ProcessStartInfo startInfo = new ProcessStartInfo();

// specify the address of your java app
startInfo.FileName = "JVM_PATH_HERE.EXE";

// input for your java app
startInfo.Arguments = "-jar JAVA_APP_PATH_HERE.exe";

// do not show your java app window
startInfo.WindowStyle = ProcessWindowStyle.Hidden;

// redirect standart input/output for your needs
startInfo.RedirectStandardInput = true;
startInfo.RedirectStandardOutput = true;

using (Process javaProc = Process.Start(startInfo))
{
    StreamReader oReader2 = p.StandardOutput;

    // get results from your java app
    string javaResults = oReader2.ReadToEnd();
    oReader2.Close();

    // do whatever your like with results;
    AnalizeResults(javaResults);
}