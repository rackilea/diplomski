public class cdinventoryItem implements Comparable<cdinventoryItem> {
  // your code

  public int compareTo(cdinventoryItem otherItem) {
    return this.Ptitle.compareTo(otherItem.getTitle());
  }

  public String getTitle() {
    return Ptitle;
  }
}