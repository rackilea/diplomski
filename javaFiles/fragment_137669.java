import java.io.FileReader;

import com.google.gson.Gson;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    Gson gson = new Gson();
    resultContainer result = gson.fromJson(new FileReader("input.json"), resultContainer.class);
    System.out.println(gson.toJson(result));
  }
}

class resultContainer
{
  String fieldA;
  MyCollectionContainer myCollection;
}

class MyCollectionContainer
{
  SomeOtherClass[] AnotherClass;
}

class SomeOtherClass
{
  String objectAfieldA;
  String objectAfieldB;
}