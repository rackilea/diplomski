package de.scrum_master.app;

import java.util.Scanner;

public class Contact {
  private String name;
  private String street;
  private String city;
  private String state;
  private int zip;
  private long phoneNumber;

  private Scanner input;

  public Contact() {}

  public Contact(String name, String street, String city, String state, int zip, long phoneNumber) {
    this.name = name;
    this.street = street;
    this.city = city;
    this.state = state;
    this.zip = zip;
    this.phoneNumber = phoneNumber;
  }

  @Override
  public String toString() {
    return "Contact[name=" + name + ", street=" + street + ", city=" + city + ", state=" + state +
      ", zip=" + zip + ", phoneNumber=" + phoneNumber + "]";
  }

  public void updateContact() {
    input = new Scanner(System.in);

    System.out.println("Please enter contact Name and Lastname: ");
    name = input.nextLine();
    System.out.println("\nPlease enter Street of contact: ");
    street = input.nextLine();
    System.out.println("\nPlease enter City of the contact: ");
    city = input.nextLine();
    System.out.println("\nPlease enter State of the contact: ");
    state = input.nextLine();
    System.out.println("\nPlease enter the Zipcode of the contact: ");
    zip = input.nextInt();
    System.out.println("\nPlease enter the contact Phone number (Ex 1115550000): ");
    phoneNumber = input.nextLong();

    System.out.println("Done! Contact updated.\n");
  }
}