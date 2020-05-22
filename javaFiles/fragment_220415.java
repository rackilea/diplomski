String[] oldArray = { null, "four", null, "good", null, "dogs", null, "swam", null, null, null };
int size = oldArray.length;
String[] newArray = new String[size];
int index = 0;
for (int i = 0; i < size; i++) {
    if (oldArray[i] != null) {
        newArray[index++] = oldArray[i];
    }
}