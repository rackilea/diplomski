public void borrower(String nameOfBorrower)
{
  borrower = nameOfBorrower;
  borrowed = true;
  inStock = false;
  times++;
}

public int GetTimes()
{
   return times;
}