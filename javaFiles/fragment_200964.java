List<string> A = new List<String>() {
  "20", "32A", "50K", "50F", "50D", "70", "72"};

List<string>[] Bs = new List<string>[] {
  new List<string>() { "20", "32A", "72"},
  new List<string>() { "20", "32A", "70"},
  new List<string>() { "20", "32A", "40"},
  new List<string>() { "32A", "20", "70"},
};

var report = string.Join(Environment.NewLine, Bs
  .Select(B => $"[{string.Join(", ", B)}] : {(IsOrderedSubset(A, B) ? "true" : "false")}"));

Console.Write(report);