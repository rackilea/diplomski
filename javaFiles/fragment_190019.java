List permute (Array digits)
{
  List permutations = /* initialize an empty list */

  for (i=0; i<n; i++)
    {
      firstDigit = digit[i];
      Array otherDigits = /* array containing all digits except firstDigit.  */
      List subPermutations = permute(otherDigits);
      /* prepend firstDigit into each element of 'subPermutations' */
      /* add all elements of 'subPermutations' to the list 'permutations' */
    }
  return permutations;
}