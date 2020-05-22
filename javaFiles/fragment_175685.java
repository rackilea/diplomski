public class BonusPoliticCard extends Bonus {
    PoliticCard politicCard;
    public BonusPoliticCard(int number, PoliticCard politicCard) {
        this.number=number;
        this.politicCard = politicCard;
    }
    public void applyBonus(Player player){
        int i=0;
        while(i<number){
            politicCard.drawPoliticCard(player);
            i++;
        }
    }
}