String[] cmd = { "/bin/sh","/home/priyatam/timesetter.sh" };
Process p = Runtime.getRuntime.exec(cmd);
BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));

String line=null;

while((line=input.readLine()) != null) {

   log.warn(line);
}

int exitVal = process.waitFor();