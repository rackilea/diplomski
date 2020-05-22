SampleClass sampleClass = new SampleClass();
sampleClass.setOnDataListener(new SampleClass.DataInterface() {
    @Override
    public void responseData(MyResponse myResponse) {

    }
 });
sampleClass.getDataForId("UR ID");