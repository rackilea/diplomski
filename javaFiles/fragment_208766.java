public class FacebookRisp implements Serializable {

private static final long serialVersionUID = 1L;

@SerializedName("pic_square")
private String pic_square;

@SerializedName("pic")
private String pic;

@SerializedName("pic_big")
private String pic_big;

@SerializedName("pic_small")
private String pic_small;

@SerializedName("uid")
private String uid;

public String getPic() {
    return pic;
}

public void setPic(String pic) {
    this.pic = pic;
}

public String getPic_big() {
    return pic_big;
}

public void setPic_big(String pic_big) {
    this.pic_big = pic_big;
}

public String getPic_small() {
    return pic_small;
}

public void setPic_small(String pic_small) {
    this.pic_small = pic_small;
}

@SerializedName("name")
private String name;

public String getPic_square() {
    return pic_square;
}

public void setPic_square(String pic_square) {
    this.pic_square = pic_square;
}

public String getUid() {
    return uid;
}

public void setUid(String uid) {
    this.uid = uid;
}

public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}

@Override
public String toString() {
    return "FacebookRisp [pic_square=" + pic_square + ", pic=" + pic + ", pic_big=" + pic_big + ", pic_small=" + pic_small + ", uid=" + uid
            + ", name=" + name + "]";
}
}