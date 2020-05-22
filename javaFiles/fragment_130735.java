public static void main(String[] args)
{
    Character character = new Character(); //initializes the Character variable
    SaveSystem save = new SaveSystem();

    character.setStrength(5); //sets the character's strength to 5
    save.saveGame(character); //containing nothing but the character.getStrength() method
}