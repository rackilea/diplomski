public class Name {

public static NameS[] hotelList = new NameS[3];
public static NameS[] mallList = new NameS[3];
public static NameS[] restaurantList = new NameS[3];

public static void main(String[] args) {

    NameS hotel = new NameS();
    hotel.setName("1. Shangri-La");
    NameS hotel1 = new NameS();
    hotel1.setName("2. Pullman");
    NameS hotel2 = new NameS();
    hotel2.setName("3. Royal Chulan");

    hotelList[0] = hotel;
    hotelList[1] = hotel1;
    hotelList[2] = hotel2;

    for (int i=0;i<hotelList.length;i++)
    {
        hotelList[i].print();
    }


    NameS mall = new NameS();
    mall.setName("1. 1Utama");
    NameS mall1 = new NameS();
    mall1.setName("2. Paradigm");
    NameS mall2 = new NameS();
    mall2.setName("3. Curve");

    mallList[0] = mall;
    mallList[1] = mall1;
    mallList[2] = mall2;

    for (int i=0;i<mallList.length;i++)
    {
        mallList[i].print();
    }

    NameS restaurant = new NameS();
    restaurant.setName("1. Nandos");
    NameS restaurant1 = new NameS();
    restaurant1.setName("2. Kura");
    NameS restaurant2 = new NameS();
    restaurant2.setName("3. Dining at Sky");

    restaurantList[0] = restaurant;
    restaurantList[1] = restaurant1;
    restaurantList[2] = restaurant2;

    for (int i=0;i<restaurantList.length;i++)
    {
        restaurantList[i].print();
    }