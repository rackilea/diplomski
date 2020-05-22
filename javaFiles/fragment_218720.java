public class AnimalPriceKey {
  private Animal animal;
  private Color color;
  private int weight;
  private int iq;

  public AnimalPriceKey(Animal animal, Color color, int weight, int iq) {
    this.animal = animal;
    this.color = color;
    this.weight = weight;
    this.iq = iq;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((animal == null) ? 0 : animal.hashCode());
    result = prime * result + ((color == null) ? 0 : color.hashCode());
    result = prime * result + iq;
    result = prime * result + weight;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    AnimalPriceKey other = (AnimalPriceKey) obj;
    if (animal != other.animal)
      return false;
    if (color != other.color)
      return false;
    if (iq != other.iq)
      return false;
    if (weight != other.weight)
      return false;
    return true;
  }
}