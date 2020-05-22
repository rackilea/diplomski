public class AnimSprite implements Comparable
{
    float x,y,z;
    //...//

   @Override
   public int compareTo(AnimSprite o)
{
    float result = this.z - o.z;
    if (result == 0f) result = this.y - o.y;
    return ((int)(result));
    }   
}

ArrayList<AnimSprite> listofsprites = new ArrayList<AnimSprite>();

    //...//

listofsprites.add( new AnimSprite(1f,10f,0f) );      //x,y,z
listofsprites.add( new AnimSprite(15f,25f,1f) );
listofsprites.add( new AnimSprite(30f,-62f,0f) );
listofsprites.add( new AnimSprite(150f,-62f,2f) );
listofsprites.add( new AnimSprite(55f,-65f,0f) );

//...//

Collection.sort(listofsprites);

for (AnimSprite s: listofsprites) { s.draw();}