// create a filechooser;
JFileChooser chooser = new JFileChooser(cwd);
FileNameExtensionFilter xmlfilter = new FileNameExtensionFilter(
     "xml files (*.xml)", "xml");

chooser.setDialogTitle("Open schedule file");
// set selected filter
chooser.setFileFilter(xmlfilter);