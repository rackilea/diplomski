etpob.setLayoutParams(new LinearLayout.LayoutParams(0, ConvertPixels(50), ConvertPixels(15))); 

public int  ConvertPixels(int ht)
    {
        int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,ht, getActivity().getResources().getDisplayMetrics());
        return height;
    }