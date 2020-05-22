String[] args = new String[] {"/bin/bash", "-c", "sort -m -u -T /dir -o output <(zcat big-zipped-file1.gz | sort -u) <(zcat big-zipped-file2.gz | sort -u) <(zcat big-zipped-file3.gz | sort -u)"};

ProcessBuilder builder = new ProcessBuilder();
builder.command(args);
Process process = builder.start();
BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
BufferedReader error = new BufferedReader(new InputStreamReader(process.getErrorStream()));
while((line = input.readLine()) != null);
while((line = error.readLine()) != null);

process.waitFor();