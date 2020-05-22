//Prepare the Process
   ProcessStartInfo start = new ProcessStartInfo();
   if (!_javadir.Equals(String.Empty)) {
        start.FileName = this._javadir + "java.exe";
   } else {
        start.FileName = "java.exe";
   }
   start.Arguments = "-Xmx1024m -cp ./../libs/*;l2jserver.jar net.sf.l2j.gameserver.GameServer";
   start.UseShellExecute = false;
   start.RedirectStandardInput = true;
   start.RedirectStandardOutput = true;

   //Start the Process
   Process java = new Process();
   java.StartInfo = start;
   java.Start();

   //Read/Write to/from Standard Input and Output as required using:
   java.StandardInput;
   java.StandardOutput;