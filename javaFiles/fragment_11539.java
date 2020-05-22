import java.util.Random;

/*
* File: Guitar.java
* Author: Eppards,Michael
* Date: June 11, 2018
*/

class Guitar {
    private int numStrings;
    private double guitarLength;
    private Color guitarColor;
    private Manufacturer guitarManufacturer;

    enum Manufacturer {
        GIBSON,
        FENDER,
        IBANEZ;
    }

    enum Color {
        RED,
        BLUE,
        BLACK;
    }

    enum Notes {
        A(1),
        B(4),
        C(1),
        D(2),
        E(0.25),
        F(0.5),
        G(0.5);

        double duration;

        private Notes(double duration) {
            this.duration = duration;
        }
    }

    // Default Constructor
    private Guitar() {
        this.numStrings = 6;
        this.guitarLength = 28.2;
        this.guitarColor = Color.RED;
        this.guitarManufacturer = Manufacturer.GIBSON;
    }

    // Argument Constructor
    private Guitar(int numStrings, double guitarLength, Color guitarColor, Manufacturer guitarMaker) {
        this.numStrings = numStrings;
        this.guitarLength = guitarLength;
        this.guitarColor = guitarColor;
        this.guitarManufacturer = guitarMaker;
    }

    // Getters
    public int getNumStrings() {
        return numStrings;
    }

    public double getGuitarLength() {
        return guitarLength;
    }

    public Color getGuitarColor() {
        return guitarColor;
    }

    public Manufacturer getGuitarManufacturer() {
        return guitarManufacturer;
    }

    // playGuitar method for 16 randomly selected musical notes
    public String playGuitar() {
        String play = "[";

        int a;
        int b;
        // initiate a random number
        Random rn = new Random();
        // for loop to select random notes
        for (int k = 0; k < 16; k++) {
            a = rn.nextInt(7);
            b = rn.nextInt(5);
            play = play + Notes.values()[a] + "(" + Notes.values()[a].duration + ")";
            if (k != 15) play = play + ",";
        }
        play = play + ']';

        return play;
    }

    // used to return the info in a string
    public String toString() {
        String infoString = "(numStrings=" + this.numStrings + ", guitarLength=" + this.guitarLength + ",guitarManufacturer=" + this.guitarManufacturer + ",guitarColor=" + (this.guitarColor == null ? "none" : this.guitarColor.name()) + ")";
        return infoString;
    }
}