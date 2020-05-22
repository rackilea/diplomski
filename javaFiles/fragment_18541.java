public class Registry extends ArrayList<Entity> {
     public void add(Entity obj){
              ....
     }
     public boolean isDuplicate(Entity obj){
         for(Entity p: this){
             if(obj.equals(p)){ 
                 return true;
             }
         }
         return false;
     } 
     public Entity search(int id){
              ....
     }
     public void readFile(){
         otherClass.readFile(String txtfilePerson);
     } 
     public void activate(Entity obj){
              obj.setActivate;
     }
     //more methods
}