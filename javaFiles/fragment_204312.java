class Beta{}
class Alpha {
   static Beta b1;
   Beta b2;
}

void main (..){
 Beta b1 = new Beta();
 Beta b2 = new Beta();
 Alpha a1 = new Alpha();
 Alpha a2 = new Alpha();
 //1A <- pointed to by a1
 //2A <- pointed to by a2
 //1B <- pointed to by b1
 //2B <- pointed to by b2 

 a1.b1=b1;
 //1A <- pointed to by a1
 //2A <- pointed to by a2
 //1B <- pointed to by b1, Alpha.b1
 //2B <- pointed to by b2 

 a1.b2=b1;
 //1A <- pointed to by a1
 //2A <- pointed to by a2
 //1B <- pointed to by b1, Alpha.b1, a1.b2
 //2B <- pointed to by b2 

 a2.b2=b2;
 //1A <- pointed to by a1
 //2A <- pointed to by a2
 //1B <- pointed to by b1, Alpha.b1
 //2B <- pointed to by b2, a2.b2 

 a1=null; b1=null; b2 = null;
 //1A <- Eligible for GC
 //2A <- pointed to by a2
 //1B <- pointed to by Alpha.b1
 //2B <- pointed to by a2.b2 

// do stuff
}