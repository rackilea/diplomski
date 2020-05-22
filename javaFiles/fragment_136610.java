gl2.glPushMatrix(); // This preserves current MODEL_VIEW matrix so you can get back here.
                    // Think of it as a checkpoint save in a game.
                    // Most of your objects will be wrapped in push and pop.
gl2.glLoadIdentity(); // This erases the MODEL_VIEW and replaces it with an identity.
                      // This un-does your previous gluLookAt call.  You will rarely use
                      // this inside an object (but it's not impossible).
                      // Does not apply here so don't use.
gl2.glTranslatef(x, y, z); // This is what puts your object out in space for you to find
                           // as opposed to putting it at the origin.  Most objects will
                           // have a translate (and likely a rotate as well).
                           // Note that the order of operations matters:
                           // translate and then rotate != rotate and then translate.
// QUAD strip code with vertices and colors - you're okay with these.
gl2.glPopMatrix(); // This brings back the MODEL_VIEW that you originally saved by pushing
                   // it.