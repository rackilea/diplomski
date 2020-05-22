public static void main(String[] args) throws Exception {
    // The path to the documents directory.
     String dataDir = "D://test//";

    // Load the documents which store the shapes we want to render.
     Document doc = new Document(dataDir + "TestFile.doc");

    // Retrieve the target shape from the document. In our sample document
    // this is the first shape.

    RenderCellToImage(dataDir, doc);
}