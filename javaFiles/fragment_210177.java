public class GoodsList {

  public static void main(String args[]) {

    Goods g = new Goods();
    Goods g2 = new Goods();
    Goods g3 = new Goods();

    g.setGoodName("hat");
    g.setQuantity(50);
    g.setPrice(100.00);

    g2.setGoodName("pants");
    g2.setQuantity(50);
    g2.setPrice(100.00);

    g3.setGoodName("shoes");
    g3.setQuantity(50);
    g3.setPrice(100.00);

    List < Goods > goodsList = new ArrayList < Goods > ();
    goodsList.add(g);
    goodsList.add(g2);
    goodsList.add(g3);


    //printing goods:

    for (Goods g: goodsList) {
      System.out.println(g.getGoodName() + "," + g.getQuantity() + "," + g.getPrice());
    }

  }

}