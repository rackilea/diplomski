unchecked {
    // you want signed int
    int result = (int) (127 ^ 0xffffffff);

    Console.WriteLine(result);
  }