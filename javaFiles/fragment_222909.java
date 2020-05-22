public class Data {
    private String componentType, text;
    private int column, row, width, height, weightX, weightY;

    public Data(String componentType, int column, int row, int width, int height
                ,int weightX, int weightY, String text) {

        this.componentType = componentType;
        this.column = column;
        this.row = row;
        this.width = width;
        this.height = height;
        this.weightX = weightX;
        this.weightY = weightY;
        this.text = text;
   }

   // getters and setters here
}