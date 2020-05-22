package com.matsemann.libgdxloadingscreen;
//
public class SomeCoolGame extends Game {

    /**
     * Holds all our assets
     */
    public AssetManager manager = new AssetManager();

    @Override
    public void create() {
        setScreen(new LoadingScreen(this));
    }
}