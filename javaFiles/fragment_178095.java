public Abstract class Equipment {}

public class Weapon extends Equipment {}

public class Armor extends Equipment {}

public class BodyPart {
    String part;
    public BodyPart(String part) {
        this.part = part;
    }
}

public class RPG {
  public static void main(String args[]) {
      HashMap<BodyPart, Equipment> equipment = new HashMap<BodyPart, Equipment>();
      equipment.put(new BodyPart("Arm"), new Weapon());
      equipment.put(new BodyPart("Head"), new Armor());
      equipment.put(new BodyPart("Arm"), new Armor());
  }
}