enum ServerPackets {
...

private static Map<String,ServerPackets> s_map = new HashMap<String,ServerPackets>();
static {
    map.put( "@L", MESSENGERINIT);
    ...
}
public ServerPackets getEnumFromHeader( String header ) {
   return map.get( header );
}