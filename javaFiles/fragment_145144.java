public class MyKey{
       final Long orgId; // true key value
       final User user; // other values needed

       // implement equals and hashCode to ONLY use orgId. This will ensure that
       // the same cached value is returned for all requests with the same
       // orgId which is the ACTUAL key.
  }