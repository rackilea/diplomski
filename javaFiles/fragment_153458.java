public class MyChartCustomizer implements JRChartCustomizer {

    @Override
    public void customize(JFreeChart jfchart, JRChart jrchart) {
        XYPlot plot = (XYPlot) jfchart.getPlot(); //get the plot

        //Create the new date axis for y
        DateAxis yDateAxis = new DateAxis();
        //Set desired time format
        DateFormat dateFormat = new SimpleDateFormat("MMM - yyyy"); 
        yDateAxis.setDateFormatOverride(dateFormat); 
        //Add your own Tickunit if you like (you can do with out also, comment out the below line and let JFreeChart decided)
        yDateAxis.setTickUnit(new DateTickUnit(DateTickUnitType.MONTH,3));

        //Set the new y-axis to the plot
        plot.setRangeAxis(yDateAxis);
    }
}