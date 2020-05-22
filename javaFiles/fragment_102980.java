@Override
public int countRoomBySize( int size){
     int s,i,n;
 n = rooms.size();
 s = 0;
 for(i=0;i<n;i++) {
   if(rooms.get(i).getSize() > size) 
       s++;  
 }
 return(s); 
}