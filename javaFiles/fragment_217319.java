public class CollisionChecker(){

   private List colliders;

   public CollisionChecker(){    
       colliders = new ArrayList<Object>();    
   }

   public void addCollider(Object o){
       colliders.add(o);
   }

   public List<EnemySprite> getEnemySprites(){
       List<EnemySprite> enemies = new ArrayList<EnemySprite>();
       for (Object o : colliders)
           if (o instanceof EnemySprite)
               enemies.add((EnemySprite)o);
       return enemies;        
   }     
}