myclass *array[10];
for (int i = 0 ; i != 10 ; i++) {
    array[i] = new myclass();
}
...
for (int i = 0 ; i != 10 ; i++) {
    delete array[i];
}