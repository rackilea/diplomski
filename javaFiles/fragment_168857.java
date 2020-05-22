public boolean isABeat(int spot) //index would have been a better name just saying.
{
       //used this to avoid ArrayOutOfBounds Further down as it will just break when it returns false
      if(spot>=beats.length-1||spot<=0) // spot is out of bounds therefore it is false
       {
           return false;
       }
       //Makes sure it is greater than both neighbors.
       if(beats[spot]>beats[spot-1] && beats[spot] >beats[spot+1])
       return true;
       else 
       return false; //if its false

}