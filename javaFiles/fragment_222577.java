Random r = new Random();
int[] numbers = lotteryNumbers();
Arrays.sort(numbers);

for(int i=0;i<7;i++)
{
    t[i].setText(Integer.toString(numbers[i]));
    t[i].setBackground(new Color(r.nextFloat(), r.nextFloat(), r.nextFloat()));
}