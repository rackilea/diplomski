// This should only be used if readObject() behaves like
// getObjects() and is able to return any requested subtype.
// Otherwise, you'll get a ClassCastException when trying to get
// something from the derivedList in case readObject() put something
// else there (which is not a subtype of IDerived).
List<IDerived> derivedList = getObjects();

// This is the safe way to go in case you don't have
// full control over what readObject() returns.
// But if you're using it like this (all the time), you'd better
// return List<IObject> from getObjects() and get rid
// of generics.
List<? extends IObject> objectList1 = getObjects();
List<IObject> objectList2 = getObjects();