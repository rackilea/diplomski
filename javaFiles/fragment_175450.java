for (int i = 0; i < tabLayout.getTabCount(); i++) {
    View view1 = getLayoutInflater().inflate(R.layout.customtab, null);
    ImageView img = view1.findViewById(R.id.icon);
    img.setScaleType(ScaleType.FIT_XY);
    if (domestic)
        img.setImageResource(domesticImages[i]);
    else
        img.setImageResource(abroadImages[i]);
    tabLayout.getTabAt(i).setCustomView(view1);
}