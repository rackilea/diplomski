for (int i = 0; i < s.length; i++)                                    
{
  sum = (s[i] + sum);                                          
  // Finds the index of the sales person with best sales
  if (s[i] >= s[max_sale])
    max_sale = i;
  // If this sales person is not the best, then check if he is last
  else if (s[min_sale] > s[i])
    min_sale = i;   
}