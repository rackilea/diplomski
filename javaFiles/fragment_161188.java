public class ADto{
  private String name;
  private String id;
  private List<BDto> bdtos;

  public ADto(String id, String name, List<BEntity> bEntities) {
    this.id = id; this.name = name;
    this.bdtos = new ArrayList<>();
    for (BEntity b : bEntities) {
       BDto bdto = new BDto(b.id, b.code, b.cEntities); 
    /* you need to pass cEntities and map them again in the BDto 
     * constructor, or you may do the apping in ADto constructor
     * and only pass mapped values to BDto constructor */
    }
  }
}