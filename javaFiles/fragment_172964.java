package com.rais;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rais.vo.Passenger;

/**
 * @author Rais.Alam
 * @date Dec 17, 2012
 */
public class Client
{

    public static void main(String[] args)
    {
        Client client = new Client();

    Passenger p1 = new Passenger("A", "USA");
    Passenger p2 = new Passenger("B", "USA");
    Passenger p3 = new Passenger("C", "UK");
    Passenger p4 = new Passenger("D", "UK");
    Passenger p5 = new Passenger("E", "UK");
    Passenger p6 = new Passenger("F", "UK");

    List<Passenger> passengers = new ArrayList<Passenger>();
    passengers.add(p1);
    passengers.add(p2);
    passengers.add(p3);
    passengers.add(p4);
    passengers.add(p5);
    passengers.add(p6);

    System.out.println(client.getMostVistedDestination(passengers));

}

public String getMostVistedDestination(List<Passenger> passengers)
{

    Map<String, Integer> tempMap = new HashMap<String, Integer>();

    int maxCount = 0;
    String dest = "";

    for (Passenger passenger : passengers)
    {
        int count = 1;
        if (tempMap.containsKey(passenger.getDestination()))
        {
            count = tempMap.get(passenger.getDestination()) + 1;
            if (maxCount < count)
            {
                maxCount = count;
                dest = passenger.getDestination();
            }

        }
        else if (maxCount == 0)
        {
            maxCount = count;
            dest = passenger.getDestination();

        }

        tempMap.put(passenger.getDestination(), count);

    }

    return dest;

}

}