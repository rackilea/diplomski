ProcessBuilder builder = new ProcessBuilder("cmd.exe");
Process  process = builder.start();
BufferedWriter out = new BufferedWriter(new 
OutputStreamWriter(process.getOutputStream()));
InputStream stdout = process.getInputStream();

BufferedReader reader = new BufferedReader(new InputStreamReader(stdout));

out.write("start /b new.bat\n");
out.flush();
out.close();

Scanner scanner = new Scanner(stdout);
while (scanner.hasNextLine()) {
    System.out.println(scanner.nextLine());
}
System.out.println("end");
scanner.close();