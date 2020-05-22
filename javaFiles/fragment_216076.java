public class Player{

    int guessTemp;
    String name;
    int age;
    long score;


    public Player(int gTemp, int name, int age, int score){

      this.guessTemp = gTemp;
      this.name = name;
      this.age = age;
      this.score = score;
    }

   public int getGuessTemp() {
        return guessTemp;
    }
    public void setGuessTemp(int guessTemp) {
        this.guessTemp = guessTemp;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public long getScore() {
        return score;
    }
    public void setScore(long score) {
        this.score = score;
    }


}