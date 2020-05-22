try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("textFieldOutput.txt", true)))) {
writer.println(textField1Val);
writer.println(textField2Val);
// etc...
} catch (IOException e) {

}