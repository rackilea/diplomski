File inFile = ...;
File outFile = ...; // Feel free to use ".jif" as extension

if (!ImageIO.write(ImageIO.read(inFile), "JPEG", outFile)) {
    System.err.println("Could not write JPEG format"); // Should never happen
}