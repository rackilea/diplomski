// Set the number of times each method is called
public void setReps(String target, String[] sa, long reps) 
{
    boolean ChosenFastest = false;
    boolean ForwardsIsfaster = false;

    shuffleArray(sa); // Shuffle the order of Strings in array

    for (int i = 0; i < reps; i++) 
    { 
       if(ChosenFastest){
          if(ForwardsIsFaster)
            linearStringSearch(target, sa); 
          else
            backwardLinearStringSearch(target, sa);
       } else {
         linearStringSearch(target, sa); 
         backwardLinearStringSearch(target, sa);
         counter(); // counts winner
       } 

       if (reps == 1000)
          ChosenFastest = true;
          if(ForwardsWasFastest()) //similar to choose algorithm
            ForwardsIsfaster = true;
          }
       }
    }
}