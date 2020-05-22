// EnemyType is an enum
public static Enemy createEnemy(EnemyType enemyType) {
   switch (enemyType) {
     case BASIC_MONSTER:
       return new BasicMonster();
     case ORC:
       return new Orc();
     case TROLL:
       return new Troll();
     case ..... // etc...
   }
}