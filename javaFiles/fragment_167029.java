public interface RowNumberStrategy {
public int getNextRowNumber();

public class OriginalRowStrategy implements RowNumberStrategy{
    int middle;
    boolean tryHarder = false;
    int rowStep;
    int maxLines;
    int maxRows;

    int x;

    public OriginalRowStrategy(int maxRows, boolean tryHarder) {
        this.x = 0;
        this.maxRows = maxRows;
        this.middle = maxRows >> 1; // divide by 2
        this.tryHarder = tryHarder;
        rowStep = Math.max(1, maxRows >> (tryHarder ? 7 : 4));
        if (tryHarder) {
          maxLines = maxRows; // Look at the whole image, not just the center
        } else {
          maxLines = 9; // Nine rows spaced 1/16 apart is roughly the middle half of the image
        }
    }

    public int getNextRowNumber() {
        if (x > maxLines)
            return -1;

        int rowStepsAboveOrBelow = (x + 1) >> 1;
        boolean isAbove = (x & 0x01) == 0; // i.e. is x even?
        int rowNumber = middle + rowStep * (isAbove ? rowStepsAboveOrBelow : -rowStepsAboveOrBelow);
        if (rowNumber < 0 || rowNumber >= maxRows) {
          // Oops, if we run off the top or bottom, stop
          return -1;
        }

        x = x + 1;

        return rowNumber;
    }

}

public class LinearScanRowStrategy implements RowNumberStrategy{
    private final int maxRows;
    private int currentRow;
    public LinearScanRowStrategy(int totalRows) {
        maxRows = totalRows;
        currentRow = 0;
    }

    public int getNextRowNumber() {
        if (currentRow > maxRows)
            return -1;

        return maxRows - 1 - currentRow++;
    }

}

public class ProgressiveScanRowStrategy implements RowNumberStrategy{
    private final int maxRows;
    private int currentStepSize;
    private int currentStep;

    public ProgressiveScanRowStrategy(int totalRows) {
        maxRows = totalRows;
        currentStep = 0;
        currentStepSize = maxRows;
    }

    public int getNextRowNumber() {
        int nextRow = (currentStep++) * currentStepSize;
        if (nextRow < maxRows)
            return nextRow;

        currentStepSize = currentStepSize >> 1;
        if (currentStepSize <= 0)
            return -1;
        currentStep = 1;

        nextRow = currentStep * currentStepSize;

        return nextRow;
    }

}



}