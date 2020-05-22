public static void RenderCellToImage(String dataDir, Document doc)
        throws Exception {

        Cell cell = (Cell) doc.getChild(NodeType.CELL, 0, true);
        RenderNode(cell, dataDir + "TestFile.RenderCell".png",
                null);
        System.out.println("Cell rendered to image__successfully.");

    }
}
    // / <summary>
// / Renders any node in a document to the path specified using the image
// save options.
// / </summary>
// / <param name="node">The node to render.</param>
// / <param name="path">The path to save the rendered image to.</param>
// / <param name="imageOptions">The image options to use during rendering.
// This can be null.</param>
public static void RenderNode(Node node, String filePath,
        ImageSaveOptions imageOptions) throws Exception {
    // Run some argument checks.
    if (node == null)
        throw new IllegalArgumentException("Node cannot be null");

    // If no image options are supplied, create default options.
    if (imageOptions == null)
        imageOptions = new ImageSaveOptions(FileFormatUtil.extensionToSaveFormat((filePath.split("\\.")[filePath
                        .split("\\.").length - 1])));

    // Store the paper color to be used on the final image and change to
    // transparent.
    // This will cause any content around the rendered node to be removed
    // later on.
    Color savePaperColor = imageOptions.getPaperColor();
    // imageOptions.PaperColor = Color.Transparent;
    imageOptions.setPaperColor(new Color(0, 0, 0, 0));
    // There a bug which affects the cache of a cloned node. To avoid this
    // we instead clone the entire document including all nodes,
    // find the matching node in the cloned document and render that
    // instead.
    Document doc = (Document) node.getDocument().deepClone(true);
    node = doc.getChild(NodeType.ANY,node.getDocument().getChildNodes(NodeType.ANY, true).indexOf(node), true);

    // Create a temporary shape to store the target node in. This shape will
    // be rendered to retrieve
    // the rendered content of the node.
    Shape shape = new Shape(doc, ShapeType.TEXT_BOX);

    Section parentSection = (Section) node.getAncestor(NodeType.SECTION);

    // Assume that the node cannot be larger than the page in size.
    shape.setWidth(parentSection.getPageSetup().getPageWidth());
    shape.setHeight(parentSection.getPageSetup().getPageHeight());
    shape.setFillColor(new Color(0, 0, 0, 0)); // We must make the shape and
                                                // paper color transparent.

    // Don't draw a surrounding line on the shape.
    shape.setStroked(false);

    // Move up through the DOM until we find node which is suitable to
    // insert into a Shape (a node with a parent can contain paragraph,
    // tables the same as a shape).
    // Each parent node is cloned on the way up so even a descendant node
    // passed to this method can be rendered.
    // Since we are working with the actual nodes of the document we need to
    // clone the target node into the temporary shape.
    Node currentNode = node;
    while (!(currentNode.getParentNode() instanceof InlineStory
            || currentNode.getParentNode() instanceof Story || currentNode
                .getParentNode() instanceof ShapeBase)) {
        CompositeNode parent = (CompositeNode) currentNode.getParentNode()
                .deepClone(false);
        currentNode = currentNode.getParentNode();
        parent.appendChild(node.deepClone(true));
        node = parent; // Store this new node to be inserted into the shape.
    }

    // We must add the shape to the document tree to have it rendered.
    shape.appendChild(node.deepClone(true));
    parentSection.getBody().getFirstParagraph().appendChild(shape);

    // Render the shape to stream so we can take advantage of the effects of
    // the ImageSaveOptions class.
    // Retrieve the rendered image and remove the shape from the document.
    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    shape.getShapeRenderer().save(stream, imageOptions);
    shape.remove();

    // Load the image into a new bitmap.
    BufferedImage renderedImage = ImageIO.read(new ByteArrayInputStream(
            stream.toByteArray()));

    // Extract the actual content of the image by cropping transparent space
    // around
    // the rendered shape.
    Rectangle cropRectangle = FindBoundingBoxAroundNode(renderedImage);

    BufferedImage croppedImage = new BufferedImage(cropRectangle.width,
            cropRectangle.height, BufferedImage.TYPE_INT_RGB);

    // Create the final image with the proper background color.
    Graphics2D g = croppedImage.createGraphics();
    g.setBackground(savePaperColor);
    g.clearRect(0, 0, croppedImage.getWidth(), croppedImage.getHeight());

    g.drawImage(renderedImage, 0, 0, croppedImage.getWidth(),
            croppedImage.getHeight(), cropRectangle.x, cropRectangle.y,
            cropRectangle.x + cropRectangle.width, cropRectangle.y
                    + cropRectangle.height, null);




    ImageIO.write(croppedImage, "png", new File(filePath));
}