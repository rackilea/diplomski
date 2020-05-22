boolean past = true;
int i = (minutes + 2) / 5; // +2 because if it's 58 min past 7 you wanna get 8 o'clock

if(i > 6){  //we're on the left side of clock face
i = 12 - i; 
hours++;   
past = false;
   }
}