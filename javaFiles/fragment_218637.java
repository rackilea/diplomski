public class myclass {
       [...]

         private OrthographicCamera camera;
         public Vector3 posCameraDesired;

            [...]

        private void processCameraMovement(){
            /// make some camera movement
                  posCameraDesired.x+=100.0f * Gdx.graphics.getDeltaTime();
                  posCameraDesired.y+=100.0f * Gdx.graphics.getDeltaTime();
            }

        [...]

            //render method
            public void draw(){

            [...]

            processCameraMovement();
            camera.position.lerp(posCameraDesired,0.1f);//vector of the camera desired position and smoothness of the movement

            [...]



            }