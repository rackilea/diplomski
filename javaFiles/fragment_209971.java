package com.example;

import java.io.IOException;
import java.util.List;
import javafx.fxml.FXMLLoader;

public class Main {

    public static void main(String[] args) throws IOException {
        List<Animal> list = FXMLLoader.load(Main.class.getResource("Main.fxml"));
        list.forEach(System.out::println);
    }

}