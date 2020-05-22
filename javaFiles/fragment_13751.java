public final class DataObject
 {
     protected final String name;
     protected final String payload;

     private DataObject()
     {

     }

     public DataObject(final String name, final String payload)
     {
         this.name = name;
         this.payload = payload;
     }
}

// Using the factory
DataObject factory = new Factory().setName("Name").setPayload("Payload").build();

// As opposed to
DataObject dao = new DataObject("Name", "Payload");

// ==> Factory becomes redundant, only adding extra code