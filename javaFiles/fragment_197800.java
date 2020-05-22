final ProcessBuilder pb = new ProcessBuilder(
    "C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe",
    "-Command",
    "C:\\Java_Scratch2\\University.PS1"
);

final Process p = pb.start();

// and don't forget to check the result of p.waitFor()