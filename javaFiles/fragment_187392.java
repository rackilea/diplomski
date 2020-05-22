public class Die implements Comparable<Die>{

    int roll;
    final int HIGHEST_DIE_VALUE = 6;
    final int LOWEST_DIE_VALUE = 1;

    public Die() {   } 

    public int computeRoll() { 
        roll = ((int)(Math.random() * 100) % HIGHEST_DIE_VALUE + LOWEST_DIE_VALUE);
        return roll;
    }

    // I also changed this to store the value
    public int getRoll() { 
        return roll; 
    }
    public void setRoll() { this.roll = roll; }

    // This is the method you have to implement
    public int compareTo(Die d) {
        if(getRoll() < d.getRoll()) return -1;
        if(getRoll() > d.getRoll()) return +1;
        if(getRoll() == d.getRoll()) return 0;
    }

}