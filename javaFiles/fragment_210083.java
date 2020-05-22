//Game.java
package com.rarepebble.game3;

// (imports)

public class Game {
    static {
        System.loadLibrary("game3lib");
    }
    // These are the functions you defined in C++
    private native long create();
    private native void destroy(long gamePtr);    
    private native void update(long gamePtr, boolean isTouched, float x, float y);
    private native void render(long gamePtr);

    private long gamePtr = 0;

    Game() {
        gamePtr = create();
    }

    @Override
    protected void finalize() throws Throwable {
        if (gamePtr != 0) {
            destroy(gamePtr);
        }
        super.finalize();
    }

    // etc...
}