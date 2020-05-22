ProcessStartInfo start = new ProcessStartInfo();
  start.FileName = "jar";
  start.WorkingDirectory =@"C:\myDir";
  start.Arguments = @" cf myJar.jar test.zip";**
  start.UseShellExecute = false;
  start.RedirectStandardInput = true;
  start.RedirectStandardOutput = true;

  Process java = new Process();
  java.StartInfo = start;
  java.Start();

  var stdOut = java.StandardOutput.ReadToEnd();
  java.WaitForExit();
  Console.WriteLine(java.ExitCode.ToString());