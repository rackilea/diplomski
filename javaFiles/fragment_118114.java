package org.test;

import org.test.configuration.Config;

public class Main {

    public static void main(String[] args) {
        Config cfg = Config.getConfig();
        System.out.println(cfg);
    }
}