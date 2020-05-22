public class Some{
      private Map < Object, Object > map;
      public class setMap(Map < Object,Object > map){
          this.map = map;//considering it was allowed and implicit casting was done.
          this.map.add(1,2);
          this.map.add(new Student(), new Object());
          this.map.add("abcd", new Student());
          this.map.add(new Employee(), new House());
          this.map.add(new Whatever(), new EveryThing());
          // In short now map can hold any object as key and value without promoting any compile error.
     }
     public void setStudentNameMap(){
           setMap(new HashMap < String, Student >());
           // What key value pairs now we expect to be of type while iterating ?
     }
}