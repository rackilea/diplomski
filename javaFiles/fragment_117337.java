public Poligon(int num, float values[]) {
    points = new Punct[num]; -- here you created an EMPTY array, it will have a length, but it is without any objects yet 
    int j = 0;

    for (int i = 0; i < num; ++i) { 
        points[i].changeCoords(values[j], values[j + 1]); // here is exception. You are trying to change Coords for NULL object
        j += 2;
    }
}