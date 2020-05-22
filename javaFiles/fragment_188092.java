package com.soquestion;
import java.util.logging.Logger;

public class Main {
    public static final Logger log = Logger.getLogger("UseLog");

    public static void main(String[] args) {
        System.out.println("arg count: " + args.length);
        log.info("hello from info");
        log.warning("hello from warning");
    }
}