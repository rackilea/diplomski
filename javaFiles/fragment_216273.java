String selectedCar = "audi";
String correspondingModel = null;
for (int i = 0; i < cars.length; i++) {
    if (cars[i].equals(selectedCar)) {
        correspondingModel = models[i];
        break;
    }
}

// Then do whatever you want with the correspondingModel