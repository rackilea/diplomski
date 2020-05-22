public void main(){
    final ScanInfo scanInfo = processRawResult();
    listOfScanInfoObjects.add(scanInfo);
    for(int q=0;q<listOfScanInfoObjects.size();q++) {
         System.out.println("SIZE:"+ listOfScanInfoObjects.get(q).getScanObjects().size());
     }

  scanObjectList.clear();
  index++;
}