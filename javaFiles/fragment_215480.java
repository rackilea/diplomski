int indexOfChair = 0;
    int count = 1;
    while (chairs.size() > 1) {
        chairs.remove(indexOfChair);
        indexOfChair += count;// skip the count number of chairs
        count++; //increase the number of chairs to skip by 1
        indexOfChair %= chairs.size();// loop to beginning if necessary
    }