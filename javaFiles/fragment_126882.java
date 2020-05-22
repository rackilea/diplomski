package de.scrum_master.app;

import java.lang.annotation.Annotation;

@InnerAnnotation
public class Application {
    public static void main(String[] args) {
        for (Annotation annotation : Application.class.getAnnotations())
            System.out.println(annotation);
    }
}