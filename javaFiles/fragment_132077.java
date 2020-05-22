public static class B implements Serializable {

     private Serializable mData2;
     private Object mBlob;

           public B (Object blob) {
              mBlob = blob;
              mData2 = new Serializable() {
                 String data = "Foo";
                 public String toString() {
                  return data;
                 }
              };
           }

           public String toString() {
             return String.format("%s-%s-%s", getClass(), mBlob, mData2);
           }
}