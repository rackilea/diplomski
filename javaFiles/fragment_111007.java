class paintthis extends JPanel{
int[] xpoints;
int max;
int min;
int divisable; 
public paintthis(int[] array){
    xpoints = array.clone();
    max = arrayGetMaxInt(xpoints);
    min = arrayGetMinInt(xpoints);
    divisable = findDivisableWholeNumber(max, min);
}