class TestVO{

 private String name;
 private String uniqueId;

 public boolean hashCode() {
  if (uniqueId == null) return 0;
  return uniqueId.hashCode();
 }

 public boolean equals(Object o) {
  if (o instanceof TestVO) {
   TestVO other = (TestVO) o;
   return o.uniqueId.equals(uniqueId);
  }
  return false;
 }
//getters and setters
}