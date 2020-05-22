for (i = 0; i < friends.size(); i++) {

    LinearLayout currentLayout = new LinearLayout(context);
    ImageButton currentImageButton = new ImageButton(context);
    TextView currentTextView = new TextView(context);
    currentTextView.setText("....");

    currentLayout.addView(currentImageButton)
    currentLayout.addView(currentTextView);

    main.addView(currentLayout);
}