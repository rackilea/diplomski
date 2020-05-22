package de.scrum_master.aspect;

import ca1.business.Bill;

public privileged aspect MyAspect {
  before() : execution(public static void main(String[])) {
    Bill.instance = new Bill(11, "operator", "client");
  }
}