public class FlagMaker {
    public static void drawFlag(MyGrid grid, int countryCode) {
        int width = grid.getWd();
        int height = grid.getHt();
        if (countryCode == 1) {
            for (int rowNum = 0; rowNum < height/2; rowNum++) {
                for (int colNum = 0; colNum < width; colNum++) {
                    grid.setColor(rowNum, colNum, Color.RED);
                }
            }
            for (int rowNum = height/2; rowNum < height ; rowNum++) {
                for (int colNum = 0; colNum < width; colNum++) {
                    grid.setColor(rowNum/2, colNum, Color.WHITE);
                }
            }
        }
    }
}