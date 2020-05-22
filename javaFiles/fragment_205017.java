// create immutable point shifted from coordinate system origin by 5
ImmutablePoint ip = new ImmutablePoint(OriginConstants.x + 5, OriginConstants.y + 5);

// updating point coordinate by 10
ip.x += 10; // COMPILE ERROR 
ip.y += 10; // COMPILE ERROR

// we cannot modify final fields, but we can create new instance with shifted coordinates
ImmutablePoint shiftedIp = new ImmutablePoint(ip.x + 10, ip.y + 10);

// create mutable point shifted from coordinate system origin by 5
MutablePoint mp = new MutablePoint(OriginConstants.x + 5, OriginConstants.y + 5);

// updating point coordinate by 10
ip.x += 10; // OK
ip.y += 10; // OK