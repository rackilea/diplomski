//list of Path's
private final List<VecPath> mPaths = new ArrayList<VecPath>();

Canvas canvas = new Canvas() {
    private final Matrix mMatrix = new Matrix();

    @Override
    public void drawPath(Path path, Paint paint) {
        Path dst = new Path();

        // Get the current transform matrix
        getMatrix(mMatrix);
        // Apply the matrix to the path
        path.transform(mMatrix, dst);
        // Store the transformed path
        mPaths.add(new SvgPath(dst, new Paint(mSourcePaint)));
    }
};

// Load an SVG document
SVG svg = SVG.getFromResource(context, R.raw.map_usa);
// Capture the paths
svg.renderToCanvas(canvas);