float maxNumb = scan.nextFloat();
float secondMax = scan.nextFloat();
if (secondMax > maxNumb) {
   float temp = maxNumb;
   maxNumb = secondMax;
   secondMax = temp;
}