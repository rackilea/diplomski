public static void main() {
    BST tree = //constructed BST
    PrintStream output = new PrintStream(new File(//name of file to write to));
    tree.write(output); // to write the tree to a file
    FileInputStream input = new FileInputStream(//file name goes here);
    tree.read(input); // to construct the tree from a file
}