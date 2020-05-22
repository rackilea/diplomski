// load PS document
PSDocument document = new PSDocument();
document.load(new File("input.ps"));

// create renderer
SimpleRenderer renderer = new SimpleRenderer();

// set resolution (in DPI)
renderer.setResolution(300);

// render
List<Image> images = renderer.render(document);