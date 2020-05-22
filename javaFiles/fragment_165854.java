if (thelist == theCarList) { 
    for (int i = 0; i < thelist.size(); i++) {
        Car curCar = (Car) thelist.get(i); 

        if(curCar.getMake().equals("BMW"){ //THIS IS THE LINE YOU ARE MISSING

            listmake = listmake + "<li>" + (curCar.getModel() + "</li>"); 
        }
    }
}