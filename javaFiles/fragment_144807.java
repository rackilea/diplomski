for(int i=1; i<segments.length; i++){
    MarvinImage memory = new MarviImage();
    MarvinSegment seg = segments[i];
    x1 =seg.x1; 
    y1 = seg.y1;
    width = seg.width; 
    height =seg.height;
    crop(original,memory,x1,y1,width,height);

    ImgSeg[i-1]=memory;
    //System.out.println(width+"  "+height);

    //System.out.println(ImgSeg.size()); 
    counter =segments.length-1;
    //contour(i);
}