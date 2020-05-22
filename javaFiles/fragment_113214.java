JHelp helpViewer = null;
try {
  // Get the class loader of the shared directory. Note that directories are
  // required to have a trailing '/' or '\'.
  ClassLoader cl = new URLClassLoader(new URL[] {new URL("file:///path/to/share/")});
  // Use the findHelpSet method of HelpSet to create a URL referencing the helpset file.
  // Note that in this example the location of the helpset is implied as being in the same
  // directory as the program by specifying "jhelpset.hs" without any directory prefix,
  // this should be adjusted to suit the implementation.
  URL url = HelpSet.findHelpSet(cl, "jhelpset.hs");
  // Create a new JHelp object with a new HelpSet.
  helpViewer = new JHelp(new HelpSet(cl, url));
}