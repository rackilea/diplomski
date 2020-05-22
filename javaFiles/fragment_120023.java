OutputWindow console = new OutputWindow("Console");
SwingUtilities.invokeLater(console);

try {
    System.out.println(2 / 0);     // just to throw an exception
} catch (ArithmeticException ex) {
    console.printStackTrace(ex);
}