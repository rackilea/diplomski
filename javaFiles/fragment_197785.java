package main.java;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogManager().getLogger(Main.class.getName());

        //Must set the level to FINEST in the code because the config file will not understand a custom level.
        logger.setLevel(Level.FINEST);

        logger.info("info lvl");
        logger.finest("finest lvl");
        logger.finer("finer lvl");
        logger.fine("fine lvl");
        logger.config("config lvl");
        logger.warning("warning lvl");
        logger.severe("severe lvl");
    }

}