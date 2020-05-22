package de.scrum_master.app;

public class Menu {
  public void updateContact(Contact contact) {
    contact.updateContact();
  }

  public static void main(String[] args) {
    Menu menu = new Menu();
    Contact contact = new Contact("Albert Einstein", "101 Main St", "Middle of Nowhere", "Utah", 12345, 11223344);
    menu.updateContact(contact);
    menu.updateContact(contact);
  }
}