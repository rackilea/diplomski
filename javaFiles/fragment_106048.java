public class Tamagotchi{
    private int hunger;
    private int mood;
    private int fatigue;
    private int hungerBorder;
    private int moodBorder;
    private int fatigueBorder;
    private String generalCondition;

    public Tamagotchi(int hungerBorder, int moodBorder, int fatigueBorder)
    {
        // Instanzvariable initialisieren
        this.hunger = 30;
        this.mood = 30;
        this.fatigue = 30;
        this.hungerBorder = hungerBorder;
        this.moodBorder = moodBorder;
        this.fatigueBorder = fatigueBorder;
        this.generalCondition = "indifferent";
    }

    public void setGeneralCondition(){
        if (fatigue > fatigueBorder){
            this.generalCondition = "tired";
            return;
        }
        if ((fatigue < fatigueBorder) && (hunger > hungerBorder)){
            this.generalCondition = "hungry";
            return;
        }
        if ((mood > moodBorder) && (hunger < hungerBorder) && (fatigue < fatigueBorder)){
            this.generalCondition = "happy";
            return;
        } else {
            this.generalCondition = "indifferent";
        }
    }

    public String getGeneralCondition(){
        return generalCondition;
    }

    public void play()
    {
        if (!generalCondition.equalsIgnoreCase("hungry")){
            hunger += 2; mood += 2; fatigue += 3;
        } else {
        }
        setGeneralCondition();
    }

    public void eat(){
        if (fatigue > fatigueBorder){
            hunger -= 2; fatigue += 2;
        } else{
        }
        setGeneralCondition();
    }

    public void sleep(){
        if (hunger > hungerBorder){
            hunger += 1; mood -= 1; fatigue = 0;
        } else{
            hunger += 1; mood += 1; fatigue = 0;
        }
        setGeneralCondition();
    }

    public void pet(){
        hunger += 1;
        mood += 2;
        setGeneralCondition();
    }

    public void makeHappy(){
        eat();
        sleep();
    }
}