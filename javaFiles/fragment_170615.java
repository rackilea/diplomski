@Id
@GenericGenerator(name = "generator", strategy = "guid", parameters = {})
@GeneratedValue(generator = "generator")
public String getId() {
    return id;
}