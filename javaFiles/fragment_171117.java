// if you're only manipulating something for the entire `Airport` class,
// independent of its objects, use a `static` method (or field, for that matter)
// in this case, you are not doing `getCountAirports()` ON a certain object
public static getCountAirports() { ... }
public static int countAirports = 0;

// and these can be referenced on the CLASS:
Airport.getCountAirports();
Airport.countAirports