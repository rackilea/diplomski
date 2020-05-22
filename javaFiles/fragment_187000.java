Process process = Runtime.getRuntime ().exec (shell);
                    OutputStream stdin = process.getOutputStream ();
                    InputStream stderr = process.getErrorStream ();
                    InputStream stdout = process.getInputStream ();

                    final BufferedReader ProcessIN = new BufferedReader (new InputStreamReader(stdout));
                    final BufferedReader ProcessERROR = new BufferedReader (new InputStreamReader(stderr));
                    final BufferedWriter ProcessOUT = new BufferedWriter(new OutputStreamWriter(stdin));