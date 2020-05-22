pulic class exercise11 
{
    public static void main(String[] args)
    {
        try(Scanner in = new Scanner(System.in))
        {
          System.out.println("Mettrez votre Poids");
          double Poids = in.nextDouble();

          System.out.println("Mettrez votre Taille");
          double Taille = in.nextDouble();

          System.out.println("Mettre votre sexe");
          String gender = in.next();

          double sc = Math.pow(Poids, 0.425) * Math.pow(Taille, 0.725) *0.202;
          if( gender.equalsIgnoreCase("Homme") )
          {
            double MetH = sc * 24 * 40;
            System.out.println("Le Metabolisme pour un homme est: " + MetH);
          }
          else if( gender.equalsIgnoreCase("Femme") )
          {
            double MetF = sc * 24 * 35;
            System.out.println("Le Metabolisme pour une femme est: " + MetF);
          }
          else
          {
            System.out.println("Vous avez entré un sexe invalide");
          }
        }
    }
}