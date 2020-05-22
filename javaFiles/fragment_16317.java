public static void main(Strings[] args)
    {
      Class main = new Class();
      Hero player1 = new Hero();
      Hero player2 = new Hero();
      main.combatPhase(player1, player2);
    }

    private void combatPhase(Hero player1, Hero player2){
      player2.takeDamage(player1.giveDamage());
      player1.takeDamage(player2.giveDamage());
    }