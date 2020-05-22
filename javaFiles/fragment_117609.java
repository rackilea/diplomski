public interface LegacyObject {
   Integer getAge(); //could throw UnsupportedOperationException
   String getDesc();
   String getName(); //May throw RuntimeException
   //about 200+ other methods.
}