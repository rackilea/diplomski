package com.mongodbtest.entities;

 import java.io.Serializable;

 import org.bson.Document;

 import org.bson.BsonDocument;
 import org.bson.BsonInt32;
  import org.bson.BsonNumber;
 import org.bson.BsonString;

public class User extends BsonDocument {

/**
     * 
     */
private static final long serialVersionUID = -9167404209850672507L;
// private String _id;
private BsonString name;
private BsonString email;
private BsonString address;
private BsonInt32 phno;

public User(String name, String email, StringBuilder address, Number phno) {
    super();
    this.name = new BsonString(name);
    this.email = new BsonString(email);
    this.address = new BsonString(address.toString());
    this.phno = new BsonInt32(phno.intValue());
}

public User() {
}

public BsonString getName() {
    return this.name;
}

public void setName(String name) {
    this.name = new BsonString(name);
    this.append("name", this.name);

}

public BsonString getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = new BsonString(email);
    this.append("email", this.email);
}

public BsonString getAddress() {
    return address;
}

public void setAddress(StringBuilder address) {
    this.address = new BsonString(address.toString());
    this.append("address", this.address);
}

public BsonInt32 getPhno() {
    return phno;
}

public void setPhno(Number phno) {
    this.phno = new BsonInt32(phno.intValue());
    this.append("phno", this.phno);
}

}