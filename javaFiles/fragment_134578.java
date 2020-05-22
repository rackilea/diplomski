package com.infostream.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.infostream.serializers.JsonDateSerializer;

@Entity
@Table(name="feeds")
public class Feed extends Base {

    @ManyToOne
    @JoinColumn(name = "source_id", nullable = false)
    private Source source;


    @Column(name = "category_id", nullable = false)
    private String categoryId;

    @NotNull
    @Column(columnDefinition="text")
    private String url;

    @Column(name = "last_visited")
    private Date lastVisited;

    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
    private Set<Article> articles;

    public Feed() {
    }

    public Feed(Source source, String categoryId, String url) {
        this.source = source;
        this.categoryId = categoryId;
        this.url = url;
    }

    @JsonSerialize(using = JsonDateSerializer.class)
    public Date getLastVisited() {
        return lastVisited;
    }

    public void setLastVisited(Date lastVisited) {
        this.lastVisited = lastVisited;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



}