public class ValidatorA extends Validator<ProcessA>{
   ...
        public ValidatorA(GenericRecord payload){
           clientId = (String) DataUtils.parseRecord(payload, "clientId");
           deviceId = (String) DataUtils.parseRecord(payload, "deviceId");
           payId = (String) DataUtils.parseRecord(payload, "payId");
        }

       public  boolean isValid(){
           // validation rules specific to ProcessA
       }
    ...

}