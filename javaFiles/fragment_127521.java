TypeOfTheArray array = new TypeOfTheArray [arrayList.size()];

for(int i = 0; i < array.length; i++)
    array[i] = arrayList.get(i);

// It's important to clean up the trash :)
arrayList.clear();