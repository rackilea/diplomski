public class SummarizedValue {
  public Integer value;
  public boolean summarized;
  public String toString() { 
    return null == value? "" : value.toString();
  }
}

public class SummaryComparator implements Comparator<SummarizedValue> {
  public int compare(SummarizedValue v1, SummarizedValue v2) {
    if (v1.summarized) return 1;
    if (v2.summarized) return -1;
    return v1.value.compareTo(v2.value);
  }
}

public class SummaryBackComparator implements Comparator<SummarizedValue> {
  public int compare(SummarizedValue v1, SummarizedValue v2) {
    if (v1.summarized) return 1;
    if (v2.summarized) return -1;
    return v2.value.compareTo(v1.value);
  }
}