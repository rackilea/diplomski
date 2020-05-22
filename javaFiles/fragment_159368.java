package com;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "NATS")

public class NATS
    implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer code;
    private String name;
    // for foreign key purpose
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "cap_id")
    private City capital;

    public City getCapital()
    {
        return this.capital;
    }

    public void setCapital(City newcapital)
    {
        this.capital = newcapital;
    }

    public Integer getCode()
    {
        return this.code;
    }

    public void setCode(Integer code)
    {
        this.code = code;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}