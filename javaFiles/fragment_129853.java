Double val = Double.parseDouble(value.toString());

    if (column == 2 && val > rpmMin
            && val < rpmMax) {
        c.setBackground(Color.PINK);
    }
    else if(column == 3 && val > speedMin
            && val < speedMax){
        c.setBackground(Color.PINK);
    }
    else if (column == 4 && val > temperatureMin
            && val < temperatureMax) {
        c.setBackground(Color.PINK);
    }
    else if(column == 5 && val > voltageMin
            && val < voltageMax){
        c.setBackground(Color.PINK);
    }
    else {
        c.setBackground(Color.GREEN);
    }