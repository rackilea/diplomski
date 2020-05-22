package com.test.testapp.challenges;

import com.test.testapp.annotations.Challenge;

@Challenge(key = "another_challenge")
public class AnotherChallenge {
    public String name = "Another Challenge";

    @Override
    public String toString() {
        return "AnotherChallenge{" +
                "name='" + name + '\'' +
                '}';
    }
}