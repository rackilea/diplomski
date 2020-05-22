String greatestValue = StringArray[0];
for (int i = 1; i < StringArray.length; i++){
    if (StringArray[i].compareTo(greatestValue) > 0) { // <-- or < 0 as appropriate
        greatestValue = StringArray[i];
    }
}
return greatestValue;