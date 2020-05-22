package ca1.business;

public aspect MyAspect {
  before() : execution(public static void main(String[])) {
    Bill.instance = new Bill(11, "operator", "client");
  }
}