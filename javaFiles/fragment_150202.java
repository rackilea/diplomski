Motor.A.setSpeed(1000);
Motor.B.setSpeed(1000);
Motor.A.forward();
Motor.B.forward();

if(touch.isPressed()) 
{
   LCD.drawString("Pressed", 3, 4);
}
else
{
   LCD.drawString("NOT Pressed", 3, 4);
}

Button.waitForAnyPress();

// rest of your code