Shell = new ActiveXObject("WScript.Shell");
link = Shell.CreateShortcut("Shortcut file name.lnk");
link.TargetPath = "path to your program";
link.Arguments = "program arguments";
link.Description = "shortcut description";
link.Hotkey = "CTRL+SHIFT+M";
link.Save();