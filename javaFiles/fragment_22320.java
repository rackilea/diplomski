public class Aluno {
    ...        
    //federacao
    @ManyToMany(cascade = {CascadeType.PERSIST
                         , CascadeType.MERGE
                         , CascadeType.REFRESH }) // CascadeType.REMOVE is missing here
    @JoinTable(name = "FederacaoAluno"
             , joinColumns = @JoinColumn(name = "id_aluno")
             , inverseJoinColumns = @JoinColumn(name = "id_federacao"))
    private List<Federacao> federacao;
    ...
}