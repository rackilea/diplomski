public class Film implements Comparable<Film>{
  int finalScore ;

  public Film(int finalScore){
      this.finalScore = finalScore;
  }

  public int getFinalScore(){
      return this.finalScore;
  }

  @Override
  public int compareTo(Film film2) {
      if (this.getFinalScore() < film2.getFinalScore()) return -1;
      if (this.getFinalScore() > film2.getFinalScore()) return 1;
      return 0;
  }
}