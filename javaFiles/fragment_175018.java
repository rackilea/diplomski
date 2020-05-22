Object [] objects = super.getAllKeys();
int size = objects.size();
String [] strings = new String[size];

for (int i = 0; i < size; i++)
  strings[i] = objects[i].toString();