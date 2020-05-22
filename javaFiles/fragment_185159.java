Random r = new Random();
int randNum = r.nextInt(10 - 1) + 1;
Intent intent = null;

switch(randNum) {
    case 1  :intent = new Intent(this, question1.class); break;
    case 2  :intent = new Intent(this, question2.class); break;
    case 3  :intent = new Intent(this, question3.class); break;
    .
    .
    .
    case 10 :intent = new Intent(this, question9.class); break;
    default :intent = new Intent(this, question1.class); break;
}
startActivity(intent);