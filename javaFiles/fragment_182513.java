TextView[] tvAuftrag = new TextView[5];
    ImageView[] ivStatus = new ImageView[5];
    CardView[] cvAuftrag = new CardView[5];

    int id = 0;

    for (int i = 0; i < tvAuftrag.length; i++) {
        id = getResources().getIdentifier("tvAuftrag" + (i + 1), "id", getPackageName());
        tvAuftrag[i] = findViewById(id);
        id = getResources().getIdentifier("ivStatus" + (i + 1), "id", getPackageName());
        ivStatus[i] = findViewById(id);
        id = getResources().getIdentifier("cvAuftrag" + (i + 1), "id", getPackageName());
        cvAuftrag[i] = findViewById(id);
    }