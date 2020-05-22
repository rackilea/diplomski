String filePath = "somefilepath/myfile.pdf";

// build a controller
SwingController controller = new SwingController();

// Build a SwingViewFactory configured with the controller
SwingViewBuilder factory = new SwingViewBuilder(controller);

// Use the factory to build a JPanel that is pre-configured
//with a complete, active Viewer UI.
JPanel viewerComponentPanel = factory.buildViewerPanel();

// add copy keyboard command
ComponentKeyBinding.install(controller, viewerComponentPanel);

// add interactive mouse link annotation support via callback
controller.getDocumentViewController().setAnnotationCallback(
      new org.icepdf.ri.common.MyAnnotationCallback(
             controller.getDocumentViewController()));

// Create a JFrame to display the panel in
JFrame window = new JFrame("Using the Viewer Component");
window.getContentPane().add(viewerComponentPanel);
window.pack();
window.setVisible(true);

// Open a PDF document to view
controller.openDocument(filePath);