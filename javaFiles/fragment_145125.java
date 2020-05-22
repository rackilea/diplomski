class Account {

private static Set<String> nickNameSet = new HashSet<>();

public void setNickName(String nickName) {
    if(nickNameSet.add(nickName))
    {
    this.nickName = nickName;
    }
    else {
        throw new IllegalArgumentException("Nick Name already exists");
    }
  }
}