public class Pedido {

    private final int cod;
    private static int cod_aux=1;
    private int tempo_total;
    private double preco;
    private ArrayList<Produto> array_produtos;

    public Pedido() {
        this.cod = cod_aux;
        cod_aux++;
        array_produtos= new ArrayList<Produto>();
    }

    public void addProduto(Produto prodt){
        this.array_produtos.add(prodt);
        this.tempo_total += prodt.getTempo();
        this.preco += prodt.getPreco();
    }
}