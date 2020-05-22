Random r = new Random();
int counter = 0;
while(counter <3) 
{
    int flip = r.nextInt(2);
    if (flip == 1) {
        System.out.print("H");
        counter++;
    } else {
        System.out.print("T");
        counter = 0;
    }
}