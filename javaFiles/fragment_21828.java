public class OverflowHiddenDivRenderer extends DivRenderer {
    public OverflowHiddenDivRenderer(Div modelElement) {
        super(modelElement);
    }

    @Override
    public Rectangle getOccupiedAreaBBox() {
        Rectangle rectangle = super.getOccupiedAreaBBox();
        if (height != null) {
            if (rectangle.getHeight() > height.getValue()) {
                rectangle.moveUp(rectangle.getHeight() - height.getValue()).setHeight(height.getValue());
            }
        }
        return rectangle;
    }

    @Override
    public LayoutResult layout(LayoutContext layoutContext) {
        height = getPropertyAsUnitValue(Property.HEIGHT);
        deleteProperty(Property.HEIGHT);
        LayoutResult layoutResult = super.layout(layoutContext);
        LayoutArea layoutArea = layoutResult.getOccupiedArea();
        if (layoutArea != null) {
            layoutArea.setBBox(getOccupiedAreaBBox());
        }
        return layoutResult;
    }

    UnitValue height;
}