int numLoops = 1;
for (int i = 0; i < n; i++) {
    numLoops*= (size - i);
}

for (int i = 0; i < numLoops; i++) {
    //do something
}