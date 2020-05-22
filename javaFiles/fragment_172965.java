package com.rais.vo;

/**
 * @author Rais.Alam
 * @date Dec 17, 2012
 */
public class Passenger
{
    private String name;
    private String destination;

    /**
     * @param name
     * @param destination
     */
    public Passenger(String name, String destination)
    {
        super();
        this.name = name;
        this.destination = destination;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * @return the destination
     */
    public String getDestination()
    {
        return destination;
    }

    /**
     * @param destination
     *            the destination to set
     */
    public void setDestination(String destination)
    {
        this.destination = destination;
    }

}