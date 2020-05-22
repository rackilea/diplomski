public void exec(File file, OutputStream output) throws Exception {
    Binding binding = new Binding()
    binding.setProperty("out", output) 
    GroovyShell shell = new GroovyShell(binding);
    shell.evaluate(file);
}