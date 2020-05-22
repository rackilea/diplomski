process = runtime.exec(cmd,env);

final BufferedReader reader = new BufferedReader(new InputStreamReader (process.getInputStream()));
final StringBuilder stringBuilder = new StringBuilder();

new Thread () {
    public void run () {
        String line = reader.readLine();
        stringBuilder.append(line);
    }
}.start ();
process.waitFor();