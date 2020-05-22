Process process = new ProcessBuilder(
                    "powershell.exe",
                    "-File", "C:\\path\\to\\your.ps1",
                    "-Username", userText.getText(),
                    "-Password", passwordText.getText()
                  ).start();