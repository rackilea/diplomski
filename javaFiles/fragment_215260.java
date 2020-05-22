public abstract class ReadFromFile<T> {

  public T readFile(File file) {
    String[] rawInput = doSomeStuffCommonToAll();
    return constructObject(rawInput);
  }

  abstract T constructObject(String[] rawInput);
}

public class UserFileReader extends ReadFromFile<User> {

  @Override
  User constructObject(String[] rawInput) {
    return new User(rawInput[0], rawInput[1], Integer.parseInt(rawInput[2]);
  }
}