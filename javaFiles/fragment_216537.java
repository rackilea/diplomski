public class MetaDadosInfo {
    private SimpleIntegerProperty codigoInstituicao;
    private SimpleIntegerProperty ano;
    private SimpleLongProperty size;
    private SimpleStringProperty type;
    private SimpleStringProperty name;

    public MetaDadosInfo(int codigoInstituicao, int ano, long size, String type, String name) {
        this.codigoInstituicao = new SimpleIntegerProperty (codigoInstituicao);
        this.ano = new SimpleIntegerProperty (ano);
        this.size = new SimpleLongProperty (size);
        this.type = new SimpleStringProperty (type);
        this.name = new SimpleStringProperty (name);
    }

    public int getCodigoInstituicao() {
        return codigoInstituicao.get();
    }

    public void setCodigoInstituicao(int codigoInstituicao) {
        this.codigoInstituicao.set(codigoInstituicao);
    }

    public int getAno() {
        return ano.get();
    }

    public void setAno(int ano) {
        this.ano.set(ano);
    }

    public Long getSize() {
        return size.get();
    }

    public void setSize(long size) {
        this.size.set(size);
    }

    public String getType() {
        return type.get();
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

}