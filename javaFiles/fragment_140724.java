// this constructor constructs a Location 
// of type SQUARE from a name, section, and damage.
public Location(String name, int section, int damage) {
    this.name = name;
    this.section = section;
    this.damage = damage;   
    this.type = Location.SQUARE;
    this.square = new Square(name,section,damage);
}