import java.util.ArrayList;

import com.google.gson.Gson;

public class Store {

    private String supermercado;
    private ArrayList<Article> productes;

    public String getSupermercado() {
        return supermercado;
    }
    public void setSupermercado(String supermercado) {
        this.supermercado = supermercado;
    }
    public ArrayList<Article> getProductes() {
    return productes;
    }
    public void setProductes(ArrayList<Article> productes) {
    this.productes = productes;
    }

    static Store newStore(String json_string){
    Gson gson= new Gson();
    Store store = gson.fromJson(json_string,Store.class);
    return store;
    }
}