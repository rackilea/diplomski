ProcessBuilder builder =
    new ProcessBuilder("asterisk", "-rx", "ss7 linestat");
builder.inheritIO().redirectOutput(ProcessBuilder.Redirect.PIPE);
Process p = builder.start();

long freeE1s;
try (BufferedReader buf =
        new BufferedReader(new InputStreamReader(p.getInputStream()))) {
    freeE1s = buf.lines().filter(line -> line.contains("Idle")).count();
}

p.waitFor();

System.out.println(freeE1s);