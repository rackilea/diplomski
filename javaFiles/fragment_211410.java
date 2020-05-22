String line;
PrintWriter out = new PrintWriter(new FileWriter(temp));

while ((line = br.readLine()) != null) {
    out.write(line);
}
out.flush();
out.close();
br.close();

String[] cmd = { "notepad", filePath };
Runtime runtime = Runtime.getRuntime();

Process proc = runtime.exec(cmd);

out.close();
br.close();
try {
    proc.waitFor();
} catch (InterruptedException e) {
    e.printStackTrace();
}
temp.deleteOnExit();