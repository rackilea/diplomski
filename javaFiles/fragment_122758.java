// This should be the first line of any equals() implementation:
if (object == this) {
    return true;
}
// You've got this part right: you need to check the other object's type
if (!(object instanceof StackADT)) {
    return false;
}
// Now that you know the type, cast the other object to StackADT<E>
StackADT<E> otherStack = (StackADT<E>)object;
// The next step is to check the sizes:
if (values.size() != otherStack.values.size()) {
    return false;
}
// Finally, go through the individual elements in a loop