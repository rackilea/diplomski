private void LocateJava()
    {
        String path = Environment.GetEnvironmentVariable("path");
        String[] folders = path.Split(';');
        foreach (String folder in folders)
        {
            if (File.Exists(folder + "java.exe"))
            {
                this._javadir = folder;
                return;
            } 
            else if (File.Exists(folder + "\\java.exe")) 
            {
                this._javadir = folder + "\\";
                return;
            }
        }
    }