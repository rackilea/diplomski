@Id
@Override
@GeneratedValue(generator = "uuid2")
@GenericGenerator(name = "uuid2", strategy = "uuid2")
@Column(name = "id", columnDefinition = "uuid")
public UUID getId() {
    return id;
}