interface IFilter {
   public IEnumerable<string> Filter(IEnumerable<string> file) {
   }
}

class PredicateFilter : IFilter {
   public PredicateFilter(Predicate<string> predicate) { }

   public IEnumerable<string> Filter(IEnumerable<string> file) {
      foreach (string s in file) {
         if (this.Predicate(s)) {
            yield return s;
         }
      }
   }
}

class ActionFilter : IFilter {
  public ActionFilter(Action<string> action) { }

  public IEnumerable<string> Filter(IEnumerable<string> file) {
      foreach (string s in file) {
         this.Action(s);
         yield return s;
      }
  }
}

class ReplaceFilter : IFilter {
  public ReplaceFilter(Func<string, string> replace) { }

  public IEnumerable<string> Filter(IEnumerable<string> file) {
     foreach (string s in file) {
        yield return this.Replace(s);
     }
  }
}