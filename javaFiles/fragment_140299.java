if (e.getSource() == jButton1) {
    count--;
    if (count > minvalue) {
        //...
    } else {
        count = minvalue;
        //...
    }
} else if (e.getSource() == jButton2) {
    count++;
    if (count < totalimages) {
        //...
    } else {
        count = totalimages - 1;
        //...
    }
}