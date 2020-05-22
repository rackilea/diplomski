public class AirportModel {
  ..
  @OneToMany(mappedby="airportModel", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<AirportTranslatedModel> translations;
  ..
}

public class AirportTranslatedModel {
  @Id
  @JoinColumn(name="airport_id")
  private AirportModel airportModel;

  @Id
  @Column(name="language_code", length=2)
  private String languageCode;
  ..
}
public class AirportTranslatedModelKey implements Serializable {
    private Long airportModel;

    private String languageCode;
}