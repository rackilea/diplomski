int result = 0;

  for (int i = 0; i < A.length; ++i)
    if (A[i] != A[A.length - 1] || A[0] != A[A.length - 1 - i]) {
      result = A.length - i - 1;

      break;
    }