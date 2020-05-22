String code = "Generating code...\r";
String successful = "Generating the code has been successful.\r"

[...]
try {
    System.out.print(code);
    Thread.sleep(2000);
    System.out.print(successful);
}

catch(InterruptedException e) { [...] }