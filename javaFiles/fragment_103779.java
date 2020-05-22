System.Diagnostics.Process process = new System.Diagnostics.Process();
        System.Diagnostics.ProcessStartInfo startInfo = new System.Diagnostics.ProcessStartInfo();
        startInfo.FileName = "cmd.exe";
        startInfo.Arguments = "/K java -cp libs\\*;DiabloMiner.jar -Djava.library.path=libs\\natives com.diablominer.DiabloMiner.DiabloMiner -u youruser -p yourpassword -o server";
        process.StartInfo = startInfo;
        process.Start();