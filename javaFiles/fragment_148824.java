List<Integer> objects = new ArrayList<Integer>();
            objects.add(0);
            objects.add(1);
            objects.add(2);
            objects.add(3);
            objects.add(4);

        // Shuffle the collection
    Collections.shuffle(objects);

    List<Button> buttons = new ArrayList<Button>();
    buttons.add((Button)findViewById(R.id.button0));
    buttons.add((Button)findViewById(R.id.button1));
    buttons.add((Button)findViewById(R.id.button2));
    buttons.add((Button)findViewById(R.id.button3));
    buttons.add((Button)findViewById(R.id.button4));

    for (int i = 0; i < objects.size(); i++) {
        buttons.get(i).setText(objects.get(i).toString());
    }