@Entity
@Table (name = "ponto")
public class Ponto implements java.io.Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="cliente", nullable=true)
    private UsuarioCliente cliente;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="loja", nullable=false)
    private UsuarioLoja loja;

    @Column(name="dataCriacao")
    private Date dataCriacao;

    @Column(name="dataUtilizado", length=12, nullable=true)
    private Date dataUtilizado;

    @Column(name="dataExpira")
    private Date dataExpira;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario", nullable=true)
    private Funcionario funcionario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pontoReceber", nullable=true)
    private PontoReceber pontoReceber;

    @Column(name="qtdPontos", nullable=false)
    private long qtdPontos;

    @Column(name="obsPontos", nullable = true,length=300)
    private String obsPontos;

    @NotEmpty
    @Column(name="tipo",nullable = true)
    private Integer tipo;

    public Ponto() {
    }

    public Ponto(UsuarioCliente cliente, UsuarioLoja loja, long qtdPontos) {
        this.cliente = cliente;
        this.loja = loja;
        this.qtdPontos = qtdPontos;
    }
    // getters and setters
}