public class Main {
    public static void main(String[] args) {
        String m = "Material: chair\nPrice: 302.91\nCount: 5";
        Order order = new Order(m);
        System.out.println(order.count);
        System.out.println(order.material);
        System.out.println(order.price);
    }
}


class Order {
    String material;
    String price;
    int count;
    public Order(String str){
        String[] parsedArr = str.split("\n");
        String materialStr = parsedArr[0];
        String priceStr = parsedArr[1];
        String countStr = parsedArr[2];
        this.material = materialStr.split(":")[1].trim();
        this.price = priceStr.split(":")[1].trim();
        this.count = Integer.parseInt(countStr.split(":")[1].trim());
    }
}