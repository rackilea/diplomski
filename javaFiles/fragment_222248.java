// FileReader reads text files in the default encoding.
FileReader fileReader = new FileReader(inputFile);

// Always wrap FileReader in BufferedReader.
input = new BufferedReader(fileReader);

total = input.readLine() + "\n";

while ((line = input.readLine()) != null && total != null) {
    total += line + "\n";

    System.out.println("Proof that the file says: " + line);
}

input.close();