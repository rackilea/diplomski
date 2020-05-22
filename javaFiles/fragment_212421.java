double sum = 0;
double average = 0;

for(int i = 0; i < list.length; i++)
                {
                    list[i] = r.nextGaussian() * 10 + 50;
                    sum = sum + list[i];
                    System.out.println(sum); 
                }

average = sum / list.length;
a.setText(" The mean is " + NumberFormat.getNumberInstance().format(average));