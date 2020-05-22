public abstract class Prisms implements ShapeFunctions {

    public double prismWidth;
    public double prismHeight;
    public double prismDepth;

    public double findFrontBackFaceArea(double prismHeight, double prismWidth) {
        double prismFrontBackFaceArea = prismHeight * prismWidth * 2;
        return prismFrontBackFaceArea;
    }

    public double findRightLeftFaceArea(double prismHeight, double prismDepth) {
        double prismRightLeftFaceArea = prismHeight * prismWidth * 2;
        return prismRightLeftFaceArea;
    }

    public double findTopBottomFaceArea(double prismWidth, double prismDepth) {
        double prismTopBottomFaceArea = prismWidth * prismDepth * 2;
        return prismTopBottomFaceArea;
    }

}