package com;

    public class GameScreen {
        public static void main(String...strings){
        Sprites gameSprites = new Sprites();
        System.out.println(gameSprites.enemies.names);
        String name=gameSprites.enemies.name2;// This is Highly Discouraged Approach
        System.out.println(name);
        System.out.println(gameSprites.enemies.getName());
        }
    }