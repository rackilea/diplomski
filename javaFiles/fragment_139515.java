bool r1 = shortestRoute == route1 || shortestRoute == route6;
bool r2 = shortestRoute == route2 || shortestRoute == route4;
bool r3 = shortestRoute == route3 || shortestRoute == route5;

if (r1 && r2 && r2) {
    print "all the same"
}
else if (r1 && r2) {
}
else if (r1 && r3) {
}
else if (r2 && r3) {
}
// Now individual checks for r1 r2 and r3