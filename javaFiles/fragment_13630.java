interface Filter {
  boolean passesFilter(File file);
}

class SuffixFilter implements Filter {
  SuffixFilter(String suffix) { ... }
  public boolean passesFilter(File file) {
    // return true if file has the appropriate suffix
  }
}

class ExecutableFilter implements Filter {
  ...  // filter that returns true if the file is executable
}

// now for the interesting part ...
class NegationFilter implements Filter {
  private final Filter subfilter;
  NegationFilter(Filter subfilter) {
    this.subfilter = subfilter;
  }

  public boolean passesFilter(File file) {
    return !subfilter.passesFilter(file);
  }
}

class AndFilter implements Filter {
  private final Collection<Filter> subfilters;
  AndFilter(Collection<Filter> subfilters) {
    this.subfilters = subfilters;
  }

  public boolean passesFilter(File file) {
    for (Filter subfilter : subfilters) {
      if (!subfilter.passesFilter(file)) {
        return false;
      }
    }
    return true;
  }
}

class OrFilter implements Filter {
  private final Collection<Filter> subfilters;
  OrFilter(Collection<Filter> subfilters) {
    this.subfilters = subfilters;
  }

  public boolean passesFilter(File file) {
    for (Filter subfilter : subfilters) {
      if (subfilter.passesFilter(file)) {
        return true;
      }
    }
    return false;
  }
}