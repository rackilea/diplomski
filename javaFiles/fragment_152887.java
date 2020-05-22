renderer.setDocument("file:file1.xhtml");
    renderer.layout();
    renderer.createPDF(new FileOutputStream("file1.pdf"));

    renderer.getOutputDevice().setMetadata("title", null); // <-----

    renderer.setDocument("file:file2.xhtml");
    renderer.layout();
    renderer.createPDF(new FileOutputStream("file2.pdf"));