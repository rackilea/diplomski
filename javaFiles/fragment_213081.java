ArrayList<Obj> items = new ArrayList<Obj>();

void setup(){

}
void draw () {

}
void mouseClicked () {
  items.add(new Obj("Bob"));
  println("items size: " + items.size());
} 
class Obj {
    String name;
    Obj(String name) {
        this.name = name;
    }
}