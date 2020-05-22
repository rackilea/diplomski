public int previousDay() 
        {
            if (ourDay == SUN) {
              return SAT;
            } else {                           
              return (ourDay - 1) % 7;
            }          
        }