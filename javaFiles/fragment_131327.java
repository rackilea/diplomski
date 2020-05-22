package org.better.place

import org.springframework.beans.factory.annotation.Autowire;

public class SuperDuperService{
       @Autowire
       private SuperDuperInterface superDuper;


       public void doIt(){
           superDuper.saveWorld();
       }

}