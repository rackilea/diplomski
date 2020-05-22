String actor = "Johnny Depp";
String targetActor = "John Travolta";
Map<String, Integer> connectedActorsAndDepth = new HashMap<String, Integer>();
Integer depth = 1;
Set<String> actorsAddedAtCurrentDepth = actorHashMap.get(actor);
for (String otherActor : actorsAddedAtPrecedingDepth) {
    if (otherActor.equals(targetActor)) return depth;
    connectedActorsAndDepth.put(otherActor, depth);
}
Set<String> actorsAddedAtPrecedingDepth = actorAddedAtCurrentDepth;
Integer maxDepth = 10;
while (++depth < maxDepth) {
    actorsAddedAtCurrentDepth = new HashSet<String>():
    for (String otherActor : actorsAddedAtPrecedingDepth) {
       if (otherActor.equals(targetActor)) return depth;
       if (!connectedActorsAndDepth.contains(otherActor)) {
           actorsAddedAtCurrentDepth.add(otherActor);
           connectedActorsAndDepth.put(otherActor, depth);
       }
    }
    actorsAddedAtPrecedingDepth = actorsAddedAtCurrentDepth;
}