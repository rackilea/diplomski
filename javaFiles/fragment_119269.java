recurrsiveFill(Pixel p, Color fill, Color bound) {
    p.setColor(fill);
    if(p.left.color  != bound && p.left.color != fill) 
        recurrsiveFill(p.left , fill, bound);
    if(p.right.color != bound && p.right.color != fill) 
        recurrsiveFill(p.right, fill, bound);
    if(p.up.color    != boun d&& p.up.color    != fill) 
        recurrsiveFill(p.up,    fill, bound);
    if(p.down.color  != bound && p.down.color  != fill) 
        recurrsiveFill(p.down,  fill, bound);
}