int first = 0;
  int last = A.length - 1;

  // 1st case: moving "first"
  while (first < last) {
    if (A[first] == A[last])
      first++;
    else
      break;
  }

  int diff1 = last - first;

  first = 0;
  last = A.length - 1;

  // 2nd case: moving "last"
  while (first < last) {
    if (A[first] == A[last])
      last--;
    else
      break;
  }

  int diff2 = last - first;

  // result is the max between two cases
  int result = diff1 > diff2
    ? diff1
    : diff2;