package com.infostream.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="sources")
public class Source extends Base {

    @NotNull
    @NotEmpty
    private String name;

    @OneToMany(mappedBy = "source", cascade = CascadeType.ALL)
    private Set<Feed> feeds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Source() {

    }

    public Source(String name) {
        this.name = name;
    }

}