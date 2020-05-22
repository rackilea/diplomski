if (accessoriesCriteria != null) {
   // we have accessory restrictions...

   // now apply each incoming restriction
   for (String accessoryCriteria : accessoriesCriteria) {
       // define a path to the accessories association that we can use to apply
       // the restrictions
       final Join<Car,String> accessoryJoin = (Join<Car,String>) car.join( "accessories" );
       // or, if using generated metamodel:
       // Join<Car,String> accessoryJoin = car.join( Car_.accessories );

       if (accessoryCriteria.contains("%") {
           criteria.add( cb.like( accessoryJoin, accessoryCriteria ) );
       } 
       else {
           criteria.add( cb.equal( accessoryJoin, accessoryCriteria ) );
       }
   } 
}