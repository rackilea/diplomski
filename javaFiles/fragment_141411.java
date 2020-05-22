public class MyCandlestickRenderer extends CandlestickRenderer {

    @Override
    public Paint getItemPaint(int row, int column) {

        //determine up or down candle 
        XYDataset dataset = getPlot().getDataset();
        OHLCDataset highLowData = (OHLCDataset) dataset;
        int series = row, item = column;
        Number yOpen = highLowData.getOpen(series, item);
        Number yClose = highLowData.getClose(series, item);
        boolean isUpCandle = yClose.doubleValue() > yOpen.doubleValue();

        //return the same color as that used to fill the candle
        if (isUpCandle) {
            return getUpPaint();
        }
        else {
            return getDownPaint();
        }
    }
}