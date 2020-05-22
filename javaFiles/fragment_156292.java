public class DiagramMaker {
    private final int[] data;
    private final char[] filler;
    private final int maxHeight;
    private final int columnWidth;
    private final int spacing;

    private int[] colHeights;

    public DiagramMaker(int[] data, char[] filler, int maxHeight, int columnWidth, int spacing) {
        this.data = data;
        this.filler = filler;
        this.maxHeight = maxHeight;
        this.columnWidth = columnWidth;
        this.spacing = spacing;
    }

    /**
        Primary method for writing the chart to StringBuffer
    */
    public render(StringBuffer buffer) {
    //Calculate the heights of all data columns scaled to our maxHeight
        colHeights = DiagramMaker.getColumnHeights(data, maxHeight);
    //Output all of our lines onto StringBuffer
        for (int i=0;i<maxHeight;i++) {
            printLine(buffer, i);
        }
    }

    /**
        Method for printing 1 line of the chart
    */
    public void printLine(StringBuffer buffer, int lineNum) {
    //Go through all columns
        for (int i=0;i<colHeights.length;i++) {
            //Check if current row can be seen on this line
            if (colHeights[lineNum] >= maxHeight-lineNum) {
                DiagramMaker.printColumnLine(buffer, filler[i], columnWidth);
                //Should we draw the spacing
                if (i < colHeights.length-1) {
                    DiagramMaker.printColumnLine(buffer, ' ', spacing);
                }
            }
        }
    }

/**
    Method for filling the given character specified amount of times into StringBuffer. Used for drawing columns and spacers.
*/
    protected static void printColumnLine(StringBuffer buffer, char filler, int width) {
        for (int i=0;i<width;i++) {
            buffer.append(filler);
        }
    }

    /**
        Calculates the maximal data value
    */
    protected static int getMaxData(int[] data) {
        int maxData = 0;
        for (int val : data) {
            if (val > maxData) {
                maxData = val;
            }
        }   
        return maxData;
    }

    /**
        Gets the height of each column given max height and data
    */
    protected static int[] getColumnHeights(int[] data, int maxHeight) {
        int maxData = getMaxData(data)
        int[] heights = new int[data.length];
        for (int i=0;i<data.length;i++) {
            //Calculate the scale of this column
            double scale = ((double)data[i])/maxData;
            heights[i] = (int)(scale*data[i]);
        }
    }
}