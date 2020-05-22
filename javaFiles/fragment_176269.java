//Your layout param type
 ViewGroup.LayoutParams lpm =  cover_img.getLayoutParams();
    int width = lpm.width;
    int height =width/2;
    lpm.height = height;
    cover_img.setLayoutParams(lpm);
    cover_img.requestLayout();