for (int i = 0; i < 10; i++) {
    for (int j = 0; j < 3; j++) {
        point[j] = (int)(Math.random() * 10);
    }            

    //Doesn't this line add filled Integer[] point to the 
    //end of ArrayList list?
    list.add(point);
    //...
}