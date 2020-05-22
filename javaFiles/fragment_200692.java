List<Car> carList = CarService.findCarByConfigtype(pageName);

for (int i = 0; i < carList.size(); i++) {
     Car apiData = CarRestApiController.data();
     Car carListData = carList.get(i);

     System.out.println(CarRestApiController.data().getModel());

     if (!carListData.getModel().equals(apiData.getModel())) {
         continue;
     }
     dataFound.add(carListData.getModel());

     if (!carListData.getDerivative().equals(apiData.getDerivative())) {
         continue;
     }
     dataFound.add(carListData.getDerivative());

     if (!carListData.getSvp().equals(apiData.getSvp())) {
         continue;
     }
     dataFound.add(carListData.getSvp());

     // ... and so on.
 }