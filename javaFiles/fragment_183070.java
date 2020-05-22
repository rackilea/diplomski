for (int i = 0; i < MAXH; i++){
    for(int j = 0; j < MAXV; j++){
        //For each cell create a Canvas node
        Canvas c = new Canvas(40, 40);
        GraphicsContext gc = c.getGraphicsContext2D();
        int k = r.nextInt();


        //Randomly paint the Canvas
        if (k % 3 == 0) gc.setFill(Color.BLUE);
        else if (k % 2 == 0) gc.setFill(Color.RED);
        else if (k % 7 == 0)gc.setFill(Color.GREEN);

        //Filling the Canvas
        gc.fillRect(0, 0, 40, 40);
        //Adding to our Grid Pane
        map.add(c, i, j);

        String message = "Click on cell ["+i+", "+j+"]";
        c.setOnMouseClicked(e -> {
            System.out.println(message);
            // do anything else you need with the canvas....
        });
    }
}