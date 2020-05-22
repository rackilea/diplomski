class MainBody {
  Map<ThirdParty1, MyInterface> remapper;
  ThirdPartyContainer queue;
  MainBody() {
    ThirdParty1 foo = new Builder().build();
    remapper.push(foo, new MyInterface() { ... });
    queue.append(foo);
  }

  void calledLater() {
    ThirdParty1 bar = queue.take();
    MyInterface ours = remapper.get(bar);
    if (ours != null) {
      // do something
    } else if (bar instanceof ThirdParty2) {
      // do something else
    }
  }
}