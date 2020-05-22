package com.java.graphics;

import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

public class InterfaceGraphique extends JFrame{

    private static final long serialVersionUID = 1L;


    public InterfaceGraphique() {
        System.out.println("Craetion");

        this.setTitle("My first Window");
        this.setSize(800, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // First Grapth Object
        Graph graph = new Graph();

        try {
            parcourir2("./Test", graph, new Integer(150));
        } catch (IOException e) {
            e.printStackTrace();
        }       
        this.setContentPane(graph);

        this.setVisible(true);
    }

    public static  int parcourir2 (String Path, Graph graph, Integer xValue) throws IOException {

            File repertoire = new File(Path);
            File[] liste = repertoire.listFiles(); 
            if (liste != null) {         
                for (int i = 0; i < liste.length; i++) {    
                    if (liste[i].isDirectory()) {
                        xValue = parcourir2(liste[i].getAbsolutePath(), graph, xValue);
                    }

                    if(liste[i].isFile()) {
                        Point nom = new Point(liste[i].getName(),xValue, 150,"normal");
                        graph.addPoint(nom);
                       }

                    xValue = xValue + 50;

                }
            } else {
                System.err.println( "Nom de repertoire invalide");
            }

            return xValue;

        }
}