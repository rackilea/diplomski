@Entity
public class Venda {
...

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="venda")    
    public List<Produtos> getProdutos() {
        return produtos;
    }
...
}

@Entity
public class Produtos {       
...
    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    public Venda getVenda() {
        return venda;
    }
...
}