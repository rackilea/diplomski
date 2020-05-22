public class ValidatorB extends Validator<ProcessB>{
   ...
      public ValidatorB(GenericRecord payload) {
         crossId = (String) DataUtils.parseRecord(payload, "crossId");
         maxId = (String) DataUtils.parseRecord(payload, "maxId");
         minId = (String) DataUtils.parseRecord(payload, "minId");
      }

      public  boolean isValid(){
          // validation rules specific to ProcessB
      }

   ...
}