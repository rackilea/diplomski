Process myProcess = new Process();
Process.StartInfo.UseShellExecute = false;
myProcess.StartInfo.FileName = "java";
myProcess.StartInfo.Arguments = "-jar D:\\myjava.jar";
myProcess.StartInfo.RedirectStandardOutput = true;
myProcess.Start();
var output = process.StandardOutput.ReadToEnd();