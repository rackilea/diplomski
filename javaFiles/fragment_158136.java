return caretakers.stream()
    .filter(caretaker -> caretaker.getNumber() == caretakerID)
    .map(caretaker -> caretaker.getAnimals())
    .flatMap(animals -> animals.stream())
    .map(animal -> animal.getName())
    .collect(Collectors.toList());