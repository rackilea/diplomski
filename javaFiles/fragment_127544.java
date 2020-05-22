public DTNode(Instance[] num, int start, int end)
{
  int mid = start + (end-start)/2;

  // do what you would've done in the constructor
  testValue = num[mid].getAttribute();

  // no 'return null' if statement, instead, prevent the call from ever happening
  //   leaving 'left' / 'right' as 'null' if it doesn't
  if (start <= mid-1)
    left = new DTNode(num, start, mid-1);
  if (mid+1 <= end)
    right = new DTNode(num, mid+1, end);

  // no return statement - constructors can't return anything
}