class Users{
@PrimaryKey(autoGenerate = true)
private int id;

@ColumnInfo(name = "username")
private String userName;

@ColumnInfo(name = "address")
private String address;

 public int getId() {
    return id;
   }

public void setId(int id) {
    this.id = id;
}

public String getUserName() {
    return userName;
}

public void setUserName(String userName) {
    this.userName = userName;
}

public String getAddress() {
    return address;
}

public void setAddress(String address) {
    this.address =address;
 }
}