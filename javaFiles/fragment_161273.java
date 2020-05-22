public class Model{
  @NotEmpty
  String filed1;

  @Range(min = 1, max = 150)
  int filed2;

  ....
}