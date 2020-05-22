public static String listarEncuadernados(){
        Scanner scann=new Scanner(System.in);
        int i =0;
        for (Encuadernacion tipos: Encuadernacion.values()){
            System.out.printf("\n%d.- %s", i, tipos.getDescripcion());
            i++;
        }
        System.out.println();

        int op = scann.nextInt();
        return Encuadernacion.values()[op].getDescripcion();
    }


public class Libro implements Serializable{
    public void setEncuadernado(String encuadernar){
            this.encuadernado = Encuadernacion.valueOf(encuadernar.toUpperCase());

    }

    @Override
    public String toString(){
        return encuadernado.getDescripcion();
    }
}

public class Listar {
    public static void lista(RandomAccessFile fichero)throws IOException, ClassNotFoundException{

        try{
            while(true){
                Libro libro=new Libro();
                libro.setEncuadernado(fichero.readUTF());
                System.out.println(libro.toString());
        }
       }catch(EOFException e){
        if(fichero!=null) fichero.close();
    }
}