String fileName = "filename.text"; // Your need be, I might have used .txt

try (PrintStream out = new PrintStream(new FileOutputStream(fileName))) {
    out.print(text);
} catch (FileNotFoundException fnf) {
    fnf.printStackTrace(); // your .text would take you here ;)
}