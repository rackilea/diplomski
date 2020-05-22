ArffLoader arffLoader = new ArffLoader();
arffLoader.setFile(new File(fName1));
Instances newData1 = arffLoader.getDataSet();
arffLoader.setFile(new File(fName2));
Instances newData2 = arffLoader.getDataSet();
Instances mergedData = Instances.mergeInstances( newData1 ,newData2);