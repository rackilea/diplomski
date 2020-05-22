package com.example
public class Item {

    int id;
    String title;
    String description;
    //and so on

    //Getters and setters

    public Item getSubItem(List<Item2> list2) {
      for(Item2 item2 :list2){
          if(this.getId() === item2.getId()) {
             return item2;
          }
      }           
       return null;
    }
}