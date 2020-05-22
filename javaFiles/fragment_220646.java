private static int Best(int value) {
  if (value <= 0)
    return -1;  // or throw ArgumentOutOfRangeException
  else if (value == 1)
    return 0;

  Dictionary<int, int> best = new Dictionary<int, int>() { {1, 0} };

  List<int> agenda = new List<int>() { 1 };

  for (int step = 1; ; ++step) 
    for (int i = agenda.Count - 1; i >= 0; --i) {
      int item = agenda[i];

      agenda.RemoveAt(i);

      int[] next = new int[] { item + 1, item * 2, item * 3 };

      foreach (int v in next) {
        if (v == value)
          return step;

        if (!best.ContainsKey(v)) {
          best.Add(v, step);
          agenda.Add(v);
        }
      }
    }
}