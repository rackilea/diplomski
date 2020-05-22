public class MetricData {
...

public Double getFirstDataPoint(){
    synchronized(dataPoints) {
        return dataPoints.get(0);
    }
}

private void fillData(){
    synchronized (dataPoints) {    
        dataPoints.clear();

        for(int i=0; i<100; i++){
            dataPoints.add(genRanNum(1,10));
        }
    }
}
}