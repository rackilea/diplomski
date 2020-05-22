import javax.swing.JOptionPane;

public class Pi {
    public static void main (String args[]){
        double pi = 4;
        double fraccion = 3.0;
        double cociente ;
        int firstSixDigits;
        for ( int i = 1 ; i <= 200000 ; i++ ){          

            cociente = 4.0/fraccion;

            if ( i % 2 == 0 )
                pi += cociente;
            else
                pi -= cociente;

            System.out.printf("El valor de pi en el término %d, es : %.10f \n", i , pi);

            firstSixDigits = (int) ( pi * 100000.0 ) ;



            if ( firstSixDigits % 314159 == 0  )
                    JOptionPane.showMessageDialog(null, String.format("Pi vale: %.10f este es el primer valor que empieza con 3.14159 en el término %d", pi, i));

            fraccion += 2.0;

        }

        System.exit(0);
    }
}