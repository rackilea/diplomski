ProcessBuilder pb = new ProcessBuilder(
                      "powershell.exe",
                      "-File", "C:\\path\\to\\your.ps1"
                    );
Map<String, String> env = pb.environment();
env.put("USER", userText.getText());
env.put("PASS", passwordText.getText());
Process process = pb.start();