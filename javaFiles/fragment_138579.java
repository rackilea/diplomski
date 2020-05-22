return reportElements.stream()
           .map(Car::getModel)
           .filter(model -> model.equals("Focus") || model.equals("Civic"))
           .distinct()
           .limit(2)
           .count() == 2;