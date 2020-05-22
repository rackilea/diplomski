public BlackJackDrawCard(Context context, Bitmap i) 
    {
        super(context); 

        card = i;

        setLayoutParams(new RelativeLayout.LayoutParams(card .getWidth(), card .getHeight())); // Assuming the view will be inside a relative layout.
    }