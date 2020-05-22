public Object getValueAt(int row, int col) {
    switch(col) {   
        case 0:
            // You can add any number of statements here.
            ...
            update();
            return row;
        case 1:
            ...
            update();
            return car.on(car.stops());
        default:
            ...
            update();
            return "";
    }  
}