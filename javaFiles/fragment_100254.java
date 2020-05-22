String executeCmd = "mysql -u " + username + " -p" + password +" " + dbName+" < "+" \" "+file.getCanonicalPath()+"\" " ;
Process runtimeProcess = Runtime.getRuntime().exec(executeCmd);
InputStream is = runtimeProcess.getInputStream();

// Do one OR the other, but not both ;)

// If you don't care about the output, but I think it's a bit of waste personally...
while (is.read() != -1) {}

// I'd at least dump the output to the console...
int byteRead = -1;
while ((byteRead = is.read()) != -1) {
    System.out.print((char)byteRead );
}

int processComplete = runtimeProcess.waitFor();
if (processComplete == 0) {...}