public class Article {

    private int id;
    private String fabricant;
    private String nombre;
    private float precio;
    private int stock;

    public int getId() {
    return id;
        }

    public void setId(int id) {
    this.id = id;
    }
    public String getFabricant() {
    return fabricant;
    }
    public void setFabricant(String fabricant) {
    this.fabricant = fabricant;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public int getStock() {
    return stock;
    }
    public void setStock(int stock) {
    this.stock = stock;
    }
}