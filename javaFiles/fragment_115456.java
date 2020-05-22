class KnownLabels
{
  Map<String, Integer> currentCountsByLabel;

  public int incrementLabelCount(String label)
  {
    Integer count = currentCountsByLabel.get(label);
    if(count==null)
      count = 1;
    else
      count += 1;

    currentCountsByLabel.put(label, count);

    return count;
  }
}

class UniqueLabelGenerator
{
  private KnownLabels knownLabels = new KnownLabels();

  public String getUniqueLabel(String label)
  {
    int i = knownLabels.incrementLabelCount(label);

    if(i>1)
      return label + ":" + i;

     return label;
  }
}