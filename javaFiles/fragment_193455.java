Process proc = new ProcessBuilder("/bin/bash", "-c",
                                  "ls /.../directory_path/*.tar.gz").start();

Reader reader = new InputStreamReader(proc.getInputStream());
int ch;
while ((ch = reader.read()) != -1)
    System.out.print((char) ch);
reader.close();