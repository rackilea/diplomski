int a = 0;
  int b = 0;
  int c = 0;
  int d = 0;
  int e = 0;
 for (int i = 1; i <= numOfQ; i++ )
{

  System.out.println("Question #" + i + ":");

  char ans = br.readLine().charAt(i - 1);

  if (ans == 'A')
  {
    a++;
  }
  else if (ans == 'B')
  {
      b++;
  } else if (ans == 'C')
  {
    c++;
  } else if (ans == 'D')
  {
    d++;
  } else if (ans == 'E')
  {
    e++;
  }
}