@Override
public void createDocuments(String[] filenames, String[] outputbases, List<RenderedFormat> formats) throws TesseractException {
    if (filenames.length != outputbases.length) {
        throw new RuntimeException("The two arrays must match in length.");
    }

    init();
    setTessVariables();

    try {
        for (int i = 0; i < filenames.length; i++) {
            File workingTiffFile = null;
            try {
                String filename = filenames[i];

                // if PDF, convert to multi-page TIFF
                if (filename.toLowerCase().endsWith(".pdf")) {
                    workingTiffFile = PdfUtilities.convertPdf2Tiff(new File(filename));
                    filename = workingTiffFile.getPath();
                }

                TessResultRenderer renderer = createRenderers(outputbases[i], formats);
                createDocuments(filename, renderer);
                api.TessDeleteResultRenderer(renderer);
            } catch (Exception e) {
                // skip the problematic image file
                logger.error(e.getMessage(), e);
            } finally {
                if (workingTiffFile != null && workingTiffFile.exists()) {
                    workingTiffFile.delete();
                }
            }
        }
    } finally {
        dispose();
    }
}

/**
 * Creates documents.
 *
 * @param filename input file
 * @param renderer renderer
 * @throws TesseractException
 */
private void createDocuments(String filename, TessResultRenderer renderer) throws TesseractException {
    api.TessBaseAPISetInputName(handle, filename); //for reading a UNLV zone file
    int result = api.TessBaseAPIProcessPages(handle, filename, null, 0, renderer);

    if (result == ITessAPI.FALSE) {
        throw new TesseractException("Error during processing page.");
    }
}