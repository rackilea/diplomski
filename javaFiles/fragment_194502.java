public class Estudiantes implements Serializable {
    private static final long serialVersionUID = 123L; // has to be unique
    String nombre, apellido;
    int numero;

    @Override
    public String toString() {
        System.out.println("first name: " + nombre);
        System.out.println("last name:  " + apellido);
        System.out.println(numero);
        return // a string you want to print
    }
}