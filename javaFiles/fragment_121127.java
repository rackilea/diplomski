long runUntilMillis = System.currentTimeMillis() + timeToRunMillis;
while (true) {
    long now = System.currentTimeMillis();
    if (now >= runUntilMillis) {
       break;
    }
    long precise_time = ...
    map1.put(precise_time, message);
}
return serializer.serialize(map1);