ArrayList<Circle> circleList = new ArrayList<>();

for (int i = 0; i < 100; i++) {
    // adds a circle with random radius
    circleList.add(new Circle((int)(Math.random() * 100)));
}

// try to sort the list
Collections.sort(circleList);   //compilation error: must be Comparable