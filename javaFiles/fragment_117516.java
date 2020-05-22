public class ValidationCellLabelProvider extends StyledCellLabelProvider {

    private static final int DELAY = 200;
    private static final int SHIFT_X = 5;
    private static final int SHIFT_Y = 5;
    private static final int DISPLAY = 5000;
    private CellLabelProvider provider;
    private String propertyName;
    private final StyleRange[] styleRanges = new StyleRange[1];

    /**
     * Default constructor.
     * @param provider provider
     * @param propertyName propertyName
     */
    public ValidationCellLabelProvider(CellLabelProvider provider, String propertyName) {
        super(StyledCellLabelProvider.COLORS_ON_SELECTION);
        this.provider = provider;
        this.propertyName = propertyName;
        this.setOwnerDrawEnabled(true);
    }

    @Override
    public void initialize(ColumnViewer viewer, ViewerColumn column) {
        super.initialize(viewer, column);
        final StyleRange styleRange = new StyleRange();
        styleRange.foreground = Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
        styleRange.background = Display.getCurrent().getSystemColor(SWT.COLOR_RED);
        styleRanges[0] = styleRange;
    }

    @Override
    public void update(ViewerCell cell) {
        provider.update(cell);
        if (cell.getStyleRanges() == null) {
            cell.setStyleRanges(styleRanges);
        }
        if (cell.getElement() instanceof IValidable) {
            IValidable model = (IValidable) cell.getElement();
            if (!ControllerRegistry.getCurrentViolations().getViolations(model.getModelId(), propertyName).isEmpty()) {
                if (cell.getText().isEmpty()) {
                    cell.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_RED));
                    cell.setImage(FieldDecorationRegistry.getDefault().getFieldDecoration(FieldDecorationRegistry.DEC_ERROR).getImage());
                } else {
                    if (styleRanges[0].length < cell.getText().length()) {
                        styleRanges[0].length = cell.getText().length();
                    }
                }
            } else {
                if (cell.getImage() != null) {
                    cell.setImage(null);
                }
                cell.setStyleRanges(null);
            }
        }
        super.update(cell);
    }

    //mine
    @Override
    protected void paint(Event event, Object element) {
        if (element instanceof IValidable) {
            IValidable model = (IValidable) element;
            if (!ControllerRegistry.getCurrentViolations().getViolations(model.getModelId(), propertyName).isEmpty()) {
                int width = 1000;
                int x = event.x;
                int y = event.y;

                int height = event.height - 1;
                GC gc = event.gc;

                Color oldBackground = gc.getBackground();

                gc.setBackground(Display.getCurrent().getSystemColor(SWT.COLOR_DARK_RED));

                gc.fillRectangle(x, y, width, height);

                gc.setBackground(oldBackground);
            }
        }
        super.paint(event, element);
    }

    //-----

    @Override
    public String getToolTipText(Object element) {
        String ret = null;
        if (element instanceof IValidable) {
            List<ConstraintViolation> constraintViolations = ControllerRegistry.getCurrentViolations().getViolations(
                    ((IValidable) element).getModelId(), propertyName);
            if (!constraintViolations.isEmpty()) {
                ret = ValidationHelper.getMessage(constraintViolations);
            }
        }
        if (ret != null) {
            ret = ret.length() > 0 ? ret.toString() : null;
        }
        return ret;
    }

    @Override
    public int getToolTipDisplayDelayTime(Object object) {
        return DELAY;
    }

    @Override
    public Point getToolTipShift(Object object) {
        return new Point(SHIFT_X, SHIFT_Y);
    }

    @Override
    public int getToolTipTimeDisplayed(Object object) {
        return DISPLAY;
    }

}