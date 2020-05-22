for (int i = 0; i < length - 1; i++) { 
    int indexLowest = i; 

    for (int j = i + 1; j < length; j++) { 

        if (array[indexLowest].getPrice() > array[j].getPrice()) {
            indexLowest = j;
        }
    }
    Pencilbox temp = array[i];
    array[i] = array[indexLowest];
    array[indexLowest] = temp;
}