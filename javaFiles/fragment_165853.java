if (thelist == theCarList) { 
    for (int i = 0; i < thelist.size(); i++) {
        Car curCar = (Car) thelist.get(i); 
        listmake = listmake + "<li>" + (curCar.getModel() + "</li>"); 
    }
}