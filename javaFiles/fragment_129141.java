public class myExtension {
    private CustomObject__c customObject;

    public myExtension(ApexPages.StandardController controller) {
        customObject = (CustomObject__c) controller.getRecord();
    }

    public PageReference save(){
        //You can now access the customObject and it will contain the 
        //data input by the user
        customObject.Name = ''; //Access properties on the object

        update customObject;
       return null;
    }
}