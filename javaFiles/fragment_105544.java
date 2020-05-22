private double selectCells(GridCoverage2D cov, int value) {
    GridGeometry2D geom = cov.getGridGeometry();
    // cov.show();
    final OperationJAI op = new OperationJAI("Histogram");
    ParameterValueGroup params = op.getParameters();
    GridCoverage2D coverage;
    params.parameter("Source").setValue(cov);
    coverage = (GridCoverage2D) op.doOperation(params, null);
    javax.media.jai.Histogram hist = (Histogram) coverage
            .getProperty("histogram");

    int total = hist.getSubTotal(0, value, value);
    double area = calcAreaOfCell(geom);
    Unit<?> unit = cov.getCoordinateReferenceSystem().getCoordinateSystem()
            .getAxis(0).getUnit();
    System.out.println("which gives " + (area * total) + " " + unit
            + "^2 area with value " + value);
    return area * total;
}

private double calcAreaOfCell(GridGeometry2D geom) {
    GridEnvelope gridRange = geom.getGridRange();
    int width = gridRange.getHigh(0) - gridRange.getLow(0) + 1; // allow for the
    int height = gridRange.getHigh(1) - gridRange.getLow(1) + 1;// 0th row/col
    Envelope envelope = geom.getEnvelope();
    double dWidth = envelope.getMaximum(0) - envelope.getMinimum(0);
    double dHeight = envelope.getMaximum(1) - envelope.getMinimum(1);
    double cellWidth = dWidth / width;
    double cellHeight = dHeight / height;

    return cellWidth * cellHeight;
}