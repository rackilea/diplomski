HelpFormatter formatter = new HelpFormatter();

    StringWriter out = new StringWriter();
    PrintWriter pw = new PrintWriter(out);

    formatter.printHelp(pw, 80, "myapp", "test-header", opts,
            formatter.getLeftPadding(), formatter.getDescPadding(), "test-footer", true);
    pw.flush();

    System.out.println("Had usage: " + out.toString());