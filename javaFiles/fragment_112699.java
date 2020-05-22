ProcessBuilder pb = new ProcessBuilder("java",
    "-Dcom.sun.management.jmxremote",
    "-Djava.rmi.server.hostname=A.B.C.D",
    // etc. etc.
    "-cp", jobArtifact.getAbsolutePath(),
    "org.springframework.batch.core.launch.support.CommandLineJobRunner");
final Process process = processBuilder.start();