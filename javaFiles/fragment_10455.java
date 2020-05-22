int lower_bound = 0, upper_bound = 10;
ArrayList<Integer> odds = new ArrayList<Integer>();

while(lower_bound < upper_bound)
{
    if(lower_bound % 2 == 1)
         odds.add(lower_bound);
    lower_bound++;
}

// Number of odd numbers found
int numberOfOddsFound = odds.size();