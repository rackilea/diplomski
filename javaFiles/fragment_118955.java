double totalHeight = box1.height + box2.height + box3.height + Math.abs(box1.y);

for(box in boxes){

    box.y -= totalHeight;

}