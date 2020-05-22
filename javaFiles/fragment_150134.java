package com.test.testapp;

import com.test.testapp.annotations.Challenge;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Reflections reflections = new Reflections("com.test.testapp");

        Set<Class<?>> challengeClasses = reflections.getTypesAnnotatedWith(Challenge.class);
        Map challengeClassesMap = challengeClasses.stream().collect(
                                                            Collectors.toMap(
                                                                    challengeClass -> challengeClass.getAnnotation(Challenge.class).key(),
                                                                    Main::createNewInstanceOfClass
                                                            )
        );

        challengeClassesMap.forEach(
                (key, challengeClass) -> System.out.println(key + " = " + challengeClass.toString())
        );
    }

    private static <T> T createNewInstanceOfClass(Class<T> someClass) {
        try {
            return someClass.newInstance();
        } catch (Exception e) {
            return null; //Bad idea but now it's waste of time
        }
    }
}