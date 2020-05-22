barChart.getXAxis().setValueFormatter(new IndexAxisValueFormatter(getXAxisValues()));



 private ArrayList<String> getXAxisValues()
{
    ArrayList<String> labels = new ArrayList<String> ();

    labels.add( "JAN");
    labels.add( "FEB");
    labels.add( "MAR");
    labels.add( "APR");
    labels.add( "MAY");
    labels.add( "JUN");
    return labels;
}