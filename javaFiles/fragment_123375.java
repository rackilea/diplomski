ArrayList<SomeClass> arr = new ArrayList<>();
int condition = 12; // example contidition number
final int prevSize = arr.size();
for (int i = 0; i < prevSize; i++) {
    SomeClass element = arr.get(i);
    if (element.conditionNumber == condition) {
        //probably update or create a new element here
        arr.add(someNewElement);
    } else {
        // process the element.
        // change the contidition
        condition = 4; // another example, this number will change many times
    }
}