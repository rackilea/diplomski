ProcessBuilder builder =
    new ProcessBuilder("asterisk", "-rx", "ss7 linestat");
builder.inheritIO().redirectOutput(ProcessBuilder.Redirect.PIPE);
Process p = builder.start();

int freeE1s = 0;
try (BufferedReader buf =
        new BufferedReader(new InputStreamReader(p.getInputStream()))) {
    String line;
    while ((line = buf.readLine()) != null) {
        if (line.contains("Idle")) {    // No need for 'grep'
            freeE1s++;                  // No need for 'wc'
        }
    }
}

p.waitFor();

System.out.println(freeE1s);