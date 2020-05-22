package com.test.testapp.challenges;

import com.test.testapp.annotations.Challenge;

@Challenge(key = "some_challenge")
public class SomeChallenge {
    public String name = "Some Challenge";

    @Override
    public String toString() {
        return "SomeChallenge{" +
                "name='" + name + '\'' +
                '}';
    }
}