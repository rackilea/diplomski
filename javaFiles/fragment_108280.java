int values = 0;
while (inFile.hasNext()) {

    values = inFile.nextInt();

    while (values > 0 && values < 101) {
        //...
        values = inFile.nextInt();
    }
}