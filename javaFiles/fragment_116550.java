private static int getInput(String axis, String point) {

int coordinate = 0;
boolean valid = false;
Scanner in = new Scanner(System.in);
while(!valid)
{
    if (in.hasNextInt()){
        coordinate = in.nextInt();
        if (coordinate >= 0 && coordinate <10){
        valid = true;
        }
    }
}
in.close();
return coordinate;
}