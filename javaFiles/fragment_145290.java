package ca1.business;

public class BillFactory {
  public static Bill create(int id, String idOperator, String idClient) {
    return new Bill(id, idOperator, idClient);
  }
}