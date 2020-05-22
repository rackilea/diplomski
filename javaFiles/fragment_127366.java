public class Player {
   final Interface obj;

   public player(Interface obj) {
       this.obj = obj;
      // some stuff, including assignment of appropriate textureID
   }

   public void draw() {
       obj.Textures.get(this.textureID).bind();
   }
}

public class ResourceLoader {
   public ResourceLoader(Interface obj) {
      obj.addTexture(new Texture("image.png"));
   }
}