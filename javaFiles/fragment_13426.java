Random botAtk = new Random();
boolean right = botAtk.nextInt(2) == 1; // flip coin only once

if(right && PRH <= 5) {
  ...
} 
else if(!right && PLH <= 5) {
  ...
}