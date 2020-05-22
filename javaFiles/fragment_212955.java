public class numerosPrimos {

    public static String CheckPrimo(int numero){
        int contador = 0;
        int residuo = 0;
        int divisores = 0; 

        for (contador=1;contador<=numero;contador++)
          {
                residuo=numero%contador;
                if(residuo==0)
                {
                    divisores++;    
                }
          }
        if(divisores>=3)
          {
            return "El numero "+numero+" no es primo";

          }
          else
          {
            return "El numero "+numero+" es primo";

          }
        }
      }