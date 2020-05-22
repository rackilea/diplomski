package de.scrum_master.aspect;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import de.scrum_master.app.Contact;
import de.scrum_master.app.Menu;

public aspect UpdateContactAspect {
  pointcut callUpdateContact(Contact contact) :
    call(void updateContact()) && within(Menu) && target(contact);

  before(Contact contact) : callUpdateContact(contact) {
    try (PrintWriter writer = new PrintWriter(new FileWriter("UpdatesLog.txt", true))) {
      writer.println("Record updated -> " + contact);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}