public interface MessageType {
  int getId();
}

public enum ConnectionMessage implements MessageType {
  INIT_CONNECTION(1),
  LOGIN(2),
  LOGOUT(3),
  CLOSE_CONNECTION(4);

  // getId code, constructor, ...
}

public enum FrobnicationMessage implements MessageType {
  FROBNICATE_FOO(5),
  FROBNICATE_BAR(6),
  DEFROB_FOO(7),
  DEFROB_BAR(8),
  ...

  // getId code, constructor, ...
}