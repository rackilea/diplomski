doSomethingRelatedToTheClass(myObject); // Doesn't need to know what you do with it.

public void doSomethingRelatedToTheClass(ObjectA object)
{
    String val = object.getValue();

    String otherVal = object.getOtherValue();
}