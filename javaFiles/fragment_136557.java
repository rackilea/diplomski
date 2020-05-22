double sum=0.0;
for(int i=0;i<addMe.length;i++)
{
  if(i%12==0 && i!=0)
  {
    System.out.println(sum);
    sum=0;
  }

  sum +=addMe[i];
}