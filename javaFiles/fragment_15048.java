package lista.enlazada1;
import java.util.Scanner;

public class ListaEnlazada1 {

    public String marca;
    public String modelo;
    public int kilometraje;
    public ListaEnlazada1 nodosiguiente;


    public static void main(String[] args) {
        /* enter the number of nodes to be created */
        Scanner leer= new Scanner(System.in);
        System.out.println("Digite la cantidad de nodos a ingresar)");
        int n,contador=0;
        n=leer.nextInt();

        // Create a node to keep the header, and an auxiliar
        // to traverse the list
        ListaEnlazada1 cab = null, aux = null;

        /* the three data of the node is entered */
        for (int i =1; i <= n; i++){
            ListaEnlazada1 nodo = new ListaEnlazada1();
            System.out.print("ingrese la marca ");
            nodo.marca=leer.next();
            System.out.print("ingrese el modelo ");
            nodo.modelo=leer.next();
            System.out.print("ingrese el kilometraje ");
            nodo.kilometraje=leer.nextInt();

            /* the node is created  */  

            if(contador==0)
                cab = aux = nodo;
            else {
                aux.nodosiguiente = nodo;
                aux = aux.nodosiguiente;
            }
            contador++;
        }

        /* nodes are printed */
        for (int i =1; i <= n; i++){
        // When using "println", automatically jumps a line
        // after printing, so there's no need to write "\n"
        // unless you want to jump a line twice
            System.out.println("marca " +cab.marca); 
            System.out.println("modelo " +cab.modelo);
            System.out.println("kilometraje " +cab.kilometraje);
            System.out.println("apuntador " +cab.nodosiguiente + "\n");
            cab = cab.nodosiguiente; // Here we get the next node
        }
    }
}