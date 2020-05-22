// first loop
states.forEach(state -> { 
    // second loop for filtered elements
    cities.stream().filter(city -> state.containsPoint(city.getLocation())).forEach(city -> { 
        System.out.printf("%30s is part of %-30s\n", city.getName(), state.getName());
    });
});