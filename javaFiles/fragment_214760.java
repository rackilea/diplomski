@POST
public Response store(SomeType myInstance) {
   if (myInstance instanceof SomeType1) {
     // fetch from database and populate more fields
   } else if (myInstance instanceof SomeType2) {
     ...
   }
   ...
}