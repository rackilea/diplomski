@Entity
public class Article {

@Column(name = "title")
private String title;

@Transient
@JsonSerialize
@JsonDeserialize
private Boolean testing;
}

// No annotations needed here
public Boolean getTesting() {
    return testing;
}

public void setTesting(Boolean testing) {
    this.testing = testing;
}