for (int i = 0; i < defense.getChildCount(); i++){
        CardView card = defense.getChildAt(i);
        ViewGroup viewGroup = ((ViewGroup)card.getChildAt(0));
        for(int j=0;j<viewGroup.getChildCount();j++){
            String getName = ((TextView)viewGroup.getChildAt(j)).getText().toString();
            id[i] = getName;
        }
    }