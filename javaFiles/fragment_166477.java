File file = getFile();
ANTLRInputStream input = new ANTLRInputStream(new FileReader(file));
ProgressMonitor progress = new ProgressMonitor(null,
                                               "Loading " + file.getName(),
                                               null,
                                               0,
                                               input.size());