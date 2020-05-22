public class Test extends TestCase {
    class AreaCompare implements Comparator<FigureGeneral> {

        @Override
        public int compare(FigureGeneral oneFigure, FigureGeneral twoFigure) {
            double firstValue = oneFigure.area();
            double secondValue = twoFigure.area();
            int result = 0;

            if (firstValue > secondValue) {
                result = 1;
            } else if (firstValue < secondValue) {
                result = -1;
            } else {
                result = 0;
            }

            return result;
        }
    }

    private final AreaCompare areaCompare = new AreaCompare();

    @Test
    public void testEqual() {
        FigureGeneral oneFigure = new FigureGeneral();
        FigureGeneral twoFigure = new FigureGeneral();
        int result = areaCompare.compare(oneFigure, twoFigure);
        assertTrue("expected to be equal", result == 0);
    }

    @Test
    public void testGreaterThan() {
        FigureGeneral oneFigure = new FigureGeneral();
        FigureGeneral twoFigure = new FigureGeneral();
        int result = areaCompare.compare(oneFigure, twoFigure);
        assertTrue("expected to be greater than", result >= 1);
    }

    @Test
    public void testLessThan() {
        FigureGeneral oneFigure = new FigureGeneral();
        FigureGeneral twoFigure = new FigureGeneral();
        int result = areaCompare.compare(oneFigure, twoFigure);
        assertTrue("expected to be less than", result <= -1);
    }
}