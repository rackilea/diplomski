abstract class MyClient implements Client {

  void businessMethod(…) {

    Dependency dependency = getDependencyInstance();
    …
  }

  abstract Dependency getDependencyInstance();
}