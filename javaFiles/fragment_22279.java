interface SomeInterface{}
enum Values implements SomeInterface {RED};
enum MoreValues implements SomeInterface {RED};

public  void dostuff2(SomeInterface value)
{
value = RED;
}