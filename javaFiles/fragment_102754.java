@Override
public void exportReportToGraphics2D(Graphics2D grx) throws JRException {

    Shape oldClipShape = grx.getClip();
    boolean printPageBorders = (Boolean) parameters.get(SRptGraphics2DExporterParameter.PRINT_PAGE_BORDERS);
    grx.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    //grx.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
    grx.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
    grx.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC);

    rotationAngle = (Double) parameters.get(SRptGraphics2DExporterParameter.ROTATION_ANGLE);

    setCurrentExporterInputItem(exporterInput.getItems().get(0));

    ReportExportConfiguration configuration = getCurrentItemConfiguration();
    AffineTransform sa = grx.getTransform();

    float zoom = 1f;

    Float zoomRatio = getCurrentItemConfiguration().getZoomRatio();
    if (zoomRatio != null) {
        zoom = zoomRatio.floatValue();
        if (zoom <= 0) {
            throw new JRRuntimeException(
                    EXCEPTION_MESSAGE_KEY_INVALID_ZOOM_RATIO,
                    new Object[]{zoom}
            );
        }
    }

    AffineTransform atrans = new AffineTransform();
    atrans.translate(
            configuration.getOffsetX() == null ? 0 : configuration.getOffsetX(),
            configuration.getOffsetY() == null ? 0 : configuration.getOffsetY()
    );
    atrans.rotate(rotationAngle);

    atrans.scale(zoom, zoom);

    grx.transform(atrans);

    List<JRPrintPage> pages = jasperPrint.getPages();
    if (pages != null) {
        PageRange pageRange = getPageRange();
        int startPageIndex = (pageRange == null || pageRange.getStartPageIndex() == null) ? 0 : pageRange.getStartPageIndex();

        PrintPageFormat pageFormat = jasperPrint.getPageFormat(startPageIndex);

        grx.clip(new Rectangle(0, 0, pageFormat.getPageWidth(), pageFormat.getPageHeight()));
        atrans = grx.getTransform();
        try {                
            AffineTransform ertrans = new AffineTransform();
            ertrans.translate(
                    configuration.getOffsetX() == null ? 0 : -configuration.getOffsetX(),
                    configuration.getOffsetY() == null ? 0 : -configuration.getOffsetY()
            ); 
            grx.transform(ertrans);

            exportPage(grx, startPageIndex);

            grx.setTransform(atrans);

            if (printPageBorders) {
                grx.drawRect(1, 1, pageFormat.getPageWidth() -1, pageFormat.getPageHeight()-1);
            }


        } finally {

            grx.setTransform(sa);
            grx.setClip(oldClipShape);

        }
    }
}