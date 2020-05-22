public class Numbers {
    private List<ImageView> numbers = new ArrayList<ImageView>();
    public Numbers() {}
    public void addNumber(ImageView v) { numbers.add(v); }
    public List<ImageView> getNumbers() { return numbers; }
}