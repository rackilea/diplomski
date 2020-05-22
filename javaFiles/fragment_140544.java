public class Hive {

    ArrayList<Bee> cells = new ArrayList<Bee>();

    public void anotherDay() {
        List<Bee> dead = new ArrayList<Bee>();
        int size = cells.size();

        for(int i = 0; i < size; i++) {
            Bee bee = cells.get(i);
            System.out.println(bee);

            // return null if the bee is dead
            if ((bee = bee.anotherDay()) == null) {
                dead.add(cells.get(i));
            } else {
                cells.set(i, bee);
            }
        }

        cells.removeAll(dead);
    }
}

public class Queen extends Bee {

    public Bee anotherDay() {
        eat();
        if (health == 0) {
            return null;
        }

        age++;
        if (age % 3 == 2) {
            hive.addBee(new Egg());
        }

        return this;
    } 

    public boolean eat() {
        if(hive.honey >= 2) {
            hive.takeHoney(2);
            if(health < 3){
                health++;
            }
            return true;
        }
        health -= 1;
        return false;
    }
}