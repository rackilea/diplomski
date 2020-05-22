public String[] menu;

public void fillMenu()
{
    menu = new String[4];

    if(Main.langPicked == 1) {
        menu[0] = "Singleplayer";
        menu[1] = "Multiplayer";
        menu[2] = "Options";
        menu[3] = "Exit Game";
    } 
    else if(Main.langPicked == 2) {
        menu[0] = "Solo";
        menu[1] = "Multijoueur";
        menu[2] = "Options";
        menu[3] = "Quitter Le Jeu";
    } 
    else if(Main.langPicked == 3) {
        menu[0] = "Singleplayer";
        menu[1] = "Multiplayer";
        menu[2] = "Opties";
        menu[3] = "Verlaat Het Spel";
    }
}