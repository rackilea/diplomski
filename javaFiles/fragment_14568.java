class MyTableObject {

     private String jsonStuff;

     private List<Stuff> stuff;

     @Lob
     @Column(name = "stuff")
     protected String getJsonStuff(){
         if(jsonStuff == null){
             jsonStuff = stuffToJsonString(stuff);
         }
         return jsonStuff;
     }

     protected void setJsonStuff(String jsonString){
         if(jsonString != null && jsonString.equals(this.jsonStuff)){
             // the new string is equal to the old one. No need to re-convert.
             return;
         }
         this.jsonStuff = jsonString;
         // jsonStuff changed we have to re-convert json to list
         // thus we set stuff to null
         stuff = null;
     }

     public List<Stuff> getStuff(){
         if(stuff == null){
             stuff = stuffFromJsonString(jsonStuff);
         }
         return Collections.unmodifiableList(stuff);
     }

     public void setStuff(List<String> stuff){
         if(suffListNotChanged(stuff)){
             // the new stuff list is equal to the old one. No need to rebuild json.
             return;
         }
         this.stuff = new ArrayList<String>(stuff);
         // the stuff list changed
         // thus the jsonStuff string must be rebuild
         this.jsonStuff = null;
     }

     private boolean suffListNotChanged(List<Stuff> stuffList){
         ...
     }

     private String stuffToJsonString(List<Stuff> stuffList){
         if(stuffList == null){
             ....
         }
     }

     private List<Stuff> stuffFromJsonString(String stuff){
         if(stuff == null){
             ....
         }
     }
}