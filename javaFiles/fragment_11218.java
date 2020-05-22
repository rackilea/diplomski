public class BackgroundContactFilter implements ContactFilter {
 @Override
 public boolean shouldCollide(Fixture fixtureA, Fixture fixtureB){
  return false;
 }

}