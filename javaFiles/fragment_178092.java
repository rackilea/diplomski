ProcessBuilder pb = new ProcessBuilder("/usr/bin/bash","/usr/local/studio.sh")
pb.directory(...);
pb.redirectErrorStream(true);
Process p = pb.start();
IOUtils.copy(p.getInputStream(), System.out);
p.waitFor();