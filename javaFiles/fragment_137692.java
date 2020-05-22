someStuff = new ConcurrentHashMap<>();

Map<A, B> someStuffCopy;
synchronized ( someStuff ) {
    someStuffCopy = new ConcurrentHashMap<A, B>( someStuff );
}