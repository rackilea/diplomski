ProcessBuilder pb = new ProcessBuilder("cmd", "/C start /B /belownormal /WAIT javaws -sdasd");
System.out.println("Before start");
Process start = pb.start();
start.destroy();
start.waitFor();

System.out.println("Done");