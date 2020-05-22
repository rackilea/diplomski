class Suffix implements Comparable<Object>
{
   /* ... */

   int getDocumentId() { /* ... */ }
   int getPosition() { /* ... */ }

   @Override
   public int compareTo(Object o)
   {
      if (o.getClass() == String.class)
      {
         /* Derived from compare code comment */
         String key = dictionary.getDocument(getDocumentId()).getData();
         String suffix = (getPosition() == 0) ? key : key.substring(getPosition());

         suffix.compareTo((String)o);
      }
      else
      {
         /* same as original comparison */
      }
   }
}