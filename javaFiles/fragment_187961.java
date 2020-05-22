Runtime runtime = Runtime.getRuntime();
Process proc = runtime.exec("adb -s ", null);

BufferedReader brInput = new BufferedReader (new InputStreamReader(proc.getInputStream()));
BufferedReader brError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

// you need to handle the reader.