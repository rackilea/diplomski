gridContainer = new GridLayout(this);
        gridContainer.setColumnCount(4);
        YOUR_OWN_VIEW.addView(gridContainer);

        for(int i = 0; i < 16; i++) 
        {
            ImageView img = new ImageView(this);
            img.setImageDrawable(this.getResources().getDrawable(R.drawable.ic_launcher));

            gridContainer.addView(img, Math.max(0, gridContainer.getChildCount()));
        }