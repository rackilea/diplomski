File[] roots = File.listRoots();

if (roots == null) {
  // you have a different problem here.  Is it even a computer we are talking about?
}

// Iterate through roots
for (File root : roots) {
    if (root.canWrite()) {  // Or, you could use File.createTempfile with that folder
        // if root does not contain some well know files
        // Or, if root contains some well known files
        // Based on these 2 hacks, or possible other characteristics, you may be reasonably sure
    }
}