package com.badlogic.gdx.backends.lwjgl;

import com.badlogic.gdx.Gdx;

public class Headless {
    public static void loadHeadless() {
        LwjglNativesLoader.load();
        Gdx.files = new LwjglFiles();
    }
}