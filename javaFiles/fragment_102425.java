interface MyActor {

   enum Type {
       // Types of actors
       a, b, c, d
   }
   Type getType();
}

Actor1 implements MyActor
Actor2 implements MyActor
Actor3 implements MyActor
Actor4 implements MyActor