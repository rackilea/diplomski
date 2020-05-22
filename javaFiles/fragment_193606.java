public class Wave<T extends Enemy> {

  List<T> enemyTypes;
  int[] delays;
  private Point spawnPoint;

  Wave(int[] delays, Point spawnPoint) {

    this.enemyTypes = new ArrayList<>();
    this.delays = delays;
    this.spawnPoint = spawnPoint;

  }

  boolean addEnemy(T enemy) {
    if(enemyTypes.contains(enemy)) {
      return false;
    }
    this.enemyTypes.add(enemy);
    return true;
  }

  void spawnWave() {

    for (int i = 0; i < enemyTypes.size(); i++) {

        try {

            Thread.sleep(delays[i]);

        } catch (Exception e) {}

        Point sP = new Point(spawnPoint);

        Enemy enemy = enemyTypes.get(i);
        enemy.spawn(sP);

    }
  }
}