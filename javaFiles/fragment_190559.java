package edu.htc.java1.phrasegame;
import edu.htc.java1.phrasegame.model.*;

import java.util.ArrayList;

public class PhraseGameController { 

    private Phrase currentPhrase; 
    private ArrayList<Character> guessed; 
    private ArrayList<Player> players; 
    boolean isRoundWon;Letter letter;

    PhraseGameController Player = new PhraseGameController();


    public void addPlayer(String name) {
        Player player= new Player(name);
        players.add(player);

    }
public boolean isRoundWon(boolean isWon) {
isWon = true;letter=new Letter();
    if(letter.isHidden() = true) {   ///<<<< Problem area, isHidden
        isWon = false;
        break;
    } else if { (letter.isHidden() = false)  ///<<<< Problem area, isHidden
    isWon = true;   
    return isWon;
    break;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }