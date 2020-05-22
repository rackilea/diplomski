LinearLayout main = new LinearLayout(context);
    main.setOrientation(LinearLayout.VERTICAL);

    // for(etc. etc.)
    LinearLayout currentRow = new LinearLayout(context);
    currentRow.setOrientation(LinearLayout.HORIZONTAL);
    LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MATCH_PARENT, 0);
    params.weight = 1.0f;
    currentRow.setLayoutParams(params);

    View viewOne = new View(context);
    params = new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
    viewOne.setLayoutParams(params);
    currentRow.addView(viewOne);

    View viewTwo = new View(context);
    params = new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
    viewTwo.setLayoutParams(params);
    currentRow.addView(viewTwo);

    main.addView(currentRow);
    //} end of for