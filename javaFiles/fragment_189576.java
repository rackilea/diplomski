...    

int RandomNumberCounter = 0;     // you have to assign a sum variable to be 0 or else it stores random value.

...

while (RandomNumber >= 0) {
    RandomNumberCounter++;

    if (RandomNumberCounter < 4) {
        ...
    }
    else {   
        Intent i = new Intent(this, Main2Activity.class);
        startActivity(i);
        break;               // this breaks execution of your while loop
    }
}