package ca1.business;

public class Bill {
  int id;
  String idOperator;
  String idClient;

  Bill(int id, String idOperator, String idClient) {
    this.id = id;
    this.idOperator = idOperator;
    this.idClient = idClient;
  }

  @Override
  public String toString() {
    return "Bill [id=" + id + ", idOperator=" + idOperator + ", idClient=" + idClient + "]";
  }

  public static Bill instance;

  public static void main(String[] args) {
    System.out.println(instance);
  }
}