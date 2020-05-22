RevertingBoolean myBool = new RevertingBoolean();
myBool.setDefaultValue(false);
myBool.setValue(false);
myBool.setRevertAfter(10000); // Revert value in 10 seconds

myBool.getValue(); // false
myBool.setValue(true);
myBool.getValue(); // true

// ... 10 seconds later ...

myBool.getValue(); // false