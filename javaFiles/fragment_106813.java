public class Entidad {

private int imgFoto;
private String titulo;
private String tiempo;
private int ratingBar;
private int colorfondo;
private int priority;

public Entidad(int imgFoto, String titulo, String tiempo, int ratingBar, int colorfondo, int priority) {
    this.imgFoto = imgFoto;
    this.titulo = titulo;
    this.tiempo = tiempo;
    this.ratingBar = ratingBar;
    this.colorfondo = colorfondo;
    this.priority = priority;
}

public int getRatingBar() {
    return ratingBar;
}

public int getPriority() {
    return priority;
}

public int getImgFoto() {
    return imgFoto;
}

public String getTitulo() {
    return titulo;
}

public String getTiempo() {
    return tiempo;
}

public int getRating() { return ratingBar; }

public int getColorfondo() {
    return colorfondo;
}
}