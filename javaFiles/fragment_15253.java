int maxDataSetSize = Math.max(data1.size(), Math.max(data2.size(), data3.size())) ;
int maxDataSetSize2 = Math.max(data4.size(), Math.max(data5.size(), data6.size()));

for (int i = 0, j = 0; i < maxDataSetSize || j < maxDataSetSize2; i++, j++) {

    View statsRowview = getLayoutInflater().inflate(R.layout.stats_row, null);

    if(i < maxDataSetSize){
        String dataset1Value = data1.size() > i ? data1.get(i) : null;
        String dataset2Value = data2.size() > i ? data2.get(i) : null;
        String dataset3Value = data3.size() > i ? data3.get(i) : null;
        fillView(statsRowview, dataset1Value, dataset2Value, dataset3Value);
    }


    if(j < maxDataSetSize2){
        String dataset4Value = data4.size() > j ? data4.get(j) : DEFAULT_COLOR;
        String dataset5Value = data5.size() > j ? data5.get(j) : DEFAULT_COLOR;
        String dataset6Value = data6.size() > j ? data6.get(j) : DEFAULT_COLOR;
        fillView2(statsRowview, dataset4Value, dataset5Value, dataset6Value);
    }

    tableStats.addView(statsRowview);
}