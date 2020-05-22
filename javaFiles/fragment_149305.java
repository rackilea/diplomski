interface Transformable {



    default void rotate (double yaw, double pitch, double roll) {
        TransformationHelper.rotate(yaw, pitch, roll);
    }

     ...
   }