class MyInterfaceList{
      @JsonProperty("MyClassAbc")
      private List<MyClass> list;

      public List<MyClass> getList(){
          return list;
      }
      public void setList(List<MyClass> list){
          this.list =list;
      }
   }