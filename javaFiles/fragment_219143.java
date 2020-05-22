private ReadOnlyStringWrapper nickName= new ReadOnlyStringWrapper();
...
public final String getNickName() {
    return nickName.get();
}

public final ReadOnlyStringProperty nickNameProperty() {
    return nickName.getReadOnlyProperty();
}