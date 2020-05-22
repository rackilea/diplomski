package mypackage;

public class TestDto {
  private final long id;
  private final String name;

  public TestDto(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}