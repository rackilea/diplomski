List<Checkbox> checkboxes = new ArrayList<Checkbox>();
    String labels[] = {"A", "B", "C", "D", "E", "F"};
    for (int i = 0; i < labels.length; i++) {
        Checkbox checkbox = new Checkbox(labels[i]);
        checkboxes.add(checkbox); //for further use you add it to the list
    }