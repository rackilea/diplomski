class SampleFactory {

     String sampleName;
     List<TargetAndValue> sampleList;


     SampleFactory(String sampleName)
     {
       this.sampleName = sampleName;
     }

     class TargetAndValue{
         String dataType;
         String ctValue;
         TargetAndValue(dataType, ctValue)
         {
            this.dataType = dataType;
            this.ctValue = ctValue;
         }
     }

     void addCtValue(dataType, ctValue) { //Instantiate a new TargetAndValue class }

     Sample build(){ //Construct your Sample here }

}