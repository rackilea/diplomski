// Do the hack; 
List<ChildObject> myChildList = (List<ChildObject>) (Object) myObjectList;
...
// Iterate over your list
for (ChildObject c : myChildList) {
    ...
}