interface Constants {
     double getAccelerationDueToGravity();
 }

 class EarthConstants implements Constants {
     double getAccelerationDueToGravity() {
         return 9.8;
     }
 }

 class MarsConstants implements Constants {
     double getAccelerationDueToGravity() {
         return 3.71;
     }
 }