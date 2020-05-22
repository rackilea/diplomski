@Entity
@Table(name ="table")
public class EscalaDetalhes{
    @id
    private Integer idDetalhe;
    @ManyToOne()
    @JoinColumn(name="mybdColumn")
    private EscalaBean escala;
    @Column(name="myColumn") 
    private Calendar dia;
    //MY QUESTION IS HERE , HOW WOULD I DESCRIBE THE RELATION HERE? 
    @OneToMany
    @JoinColumn(name="idDetalhe",referencedColumnName="idEscalaDia")
    private List<DefinicaoEscala> escalaDiaDetalhes;

    //GETTERS , SETTERS , HASH AND EQUALS

}