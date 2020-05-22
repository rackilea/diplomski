private LineDataSet createLineChart(monthlysales company,String storeName,List<String> listofcompanies){
  //  LineData data=new LineData();
    ArrayList<Entry> entries= new ArrayList<Entry>();
    for (int j = 0; j < listofcompanies.size(); j++) {

        entries.add(new Entry(Float.parseFloat(listofcompanies.get(j)),j));

linechart.notifyDataSetChanged();

    }
    Random rd = new Random();
    setComp1 = new LineDataSet(entries,storeName);


    setComp1.setColor(Color.argb(255,rd.nextInt(256),rd.nextInt(256),rd.nextInt(256)));


   // LineData data =new LineData(labels,dataset);
    return setComp1;

}