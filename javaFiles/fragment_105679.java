import java.util.concurrent.ThreadLocalRandom;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class Memory implements ApplicationListener {

    private static World world;

       private static void createNewBodies(boolean isCircle, Vector2 position, Vector2 dimensions) {
            BodyDef bodyDef = new BodyDef();
            //bodyDef.type = type; //all bodies here are dynamic
            bodyDef.type =  BodyType.DynamicBody;
            bodyDef.position.set(position);

            Body body = world.createBody(bodyDef);

            FixtureDef fixtureDef = new FixtureDef();
            Fixture fixture;
            if(isCircle){
                CircleShape circle = new CircleShape();
                circle.setRadius(dimensions.x);
                fixtureDef.shape = circle;
                fixture = body.createFixture(fixtureDef);
                circle.dispose();
            }else{
                PolygonShape rectangle = new PolygonShape();
                rectangle.setAsBox(dimensions.x, dimensions.y);
                fixtureDef.shape = rectangle;
                fixture = body.createFixture(fixtureDef);
                rectangle.dispose();
            }
       }

       public static void disposeAllBodies(){
            Array<Body> bodies = new Array<Body>();
            world.getBodies(bodies);
            int destroyCount = 0;
            System.out.println("Attempting to destroy " + world.getBodyCount()+ " bodies");
            for(Body b : bodies){
                world.destroyBody(b);
                destroyCount++;
            }

            System.out.println("Successfully destroyed " + destroyCount + " body(s), " + world.getBodyCount() + " remain");

        }

       private static void buildAllBodies() {
           int minPos = 10;
           int maxPos = 400;
           int minWidthHeight = 50;

           Vector2 position = new Vector2();
           Vector2 dimensions = new Vector2();

           for (int i=0; i<10000; i=i+2) {
               position.x = ThreadLocalRandom.current().nextInt(minPos, maxPos+1);
               position.y = ThreadLocalRandom.current().nextInt(minPos*2, maxPos*2+1);
               dimensions.x = ThreadLocalRandom.current().nextInt(minWidthHeight, minWidthHeight+1);
               dimensions.y = dimensions.x;
               createNewBodies(true, position, dimensions);
               createNewBodies(false, position, dimensions);
           }
       }

       @Override
       public void create() {

           world = new World ( new Vector2(0.0f, -9.8f), true);

           Timer.schedule(new Task() {
                   @Override
                   public void run() {
                       buildAllBodies();
                       disposeAllBodies();
                   }
              }
               , 1.0f
               , 10.0f //how often to do the cycle (in seconds)
              );
       }

       @Override
       public void render() { }

       @Override
       public void dispose() {
           world.dispose();
       }

       @Override
       public void resize(int width, int height) { }

       @Override
       public void pause() { }

       @Override
       public void resume() { }
}