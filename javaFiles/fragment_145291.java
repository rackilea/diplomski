package de.scrum_master.aspect;

import ca1.business.Bill;
import ca1.business.BillFactory;;

public aspect MyAspect {
  before() : execution(public static void main(String[])) {
    Bill.instance = BillFactory.create(11, "operator", "client");
  }
}