LinearLayout mainLayout = new LinearLayout(this);
    mainLayout.setOrientation(LinearLayout.VERTICAL);

    int totalItems = 13;
    for (int k=0; k<totalItems; k+=3)
    {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.HORIZONTAL);
        layout.setTag(k/3);

        int numberOfButtonsInRow = (k + 3 < totalItems) ? 3 : totalItems % 3;

        for(int l = 0; l < numberOfButtonsInRow; l++)
        {
            Button b = new Button(this);
            b.setTag(k + l);
            b.setText("Button " + (k + l));
            layout.addView(b);
        }

        mainLayout.addView(layout);
    }