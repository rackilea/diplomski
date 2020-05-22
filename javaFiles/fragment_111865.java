Rectangle r1 = /*Initialize*/;                             
Rectangle r2 = /*Initialize*/;                             
Rectangle intersection = new Rectangle();                  
Intersector.intersectRectangles(r1, r2, intersection);     
if(intersection.x > r1.x)                                  
    //Intersects with right side                              
if(intersection.y > r1.y)                                  
    //Intersects with top side                                
if(intersection.x + intersection.width < r1.x + r1.width)  
    //Intersects with left side                               
if(intersection.y + intersection.height < r1.y + r1.height)
    //Intersects with bottom side