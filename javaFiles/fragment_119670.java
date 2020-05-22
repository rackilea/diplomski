@Entity
@Table(name = "RSS_CHANEL")
public class RssChanelDTO implements java.io.Serializable {
    ...

    @OneToMany(mappedBy="rssch")
    Set<RssNewsDTO> news = new HashSet<RssNewsDTO>();
}


@Entity
@Table(name = "RSS_NEWS")
public class RssNewsDTO {
//try implements java.io.Serializable
    ...
    @ManyToOne
    @JoinTable(name = "RSS_CHANEL")
    private RssChanelDTO rssch;
}