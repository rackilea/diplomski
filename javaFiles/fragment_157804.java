//Mouths
tekening.setColor(Color.RED);

int second_parameter = 145;
int increment = 150;

for(int var1 = 3; var1 <= 11; var1+= 4 ){

    for(int var2 = 171; var2<=471; var2+=increment){

        tekening.fillArc(var2, second_parameter, 25, var1, 180, 180);

    }
    second_parameter+=increment;
}