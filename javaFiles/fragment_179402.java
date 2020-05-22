@Entity
public class Detail {
    ...
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pcod")
    @JsonIgnore
    private Product product;
    ...
}