for (Vehicle v : myFleet) {
     if (v instanceof Bus) {
         Bus b = (Bus)v;
         b.doSomeSpecialThingsForABus();
     }

}