int index = 0;
while (true)
{
  int num = in.nextInt();

  // if not between 10 and 100, continue
  // if it would make the array larger than 5, continue
  //    (or perhaps break out of the loop, since we've filled the array)
  // if it is already in the array, continue

  // all the checks passed, so add it to the array!
  InpNum[index++] = num;
}