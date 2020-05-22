package com.infostream.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "articles")
public class Article extends Base {

    public Article() {

    }

    public Article(Feed feed, String title, String description, String url) {
        this.feed = feed;
        this.title = title;
        this.description = description;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @ManyToOne
    @JoinColumn(name = "feed_id", nullable = false)
    private Feed feed;

    @NotNull
    @Column(columnDefinition="text")
    private String title;

    @Column(name = "img_url", columnDefinition="text")
    private String imgUrl;

    @Column(columnDefinition="text")
    private String description;

    @NotNull
    @Column(columnDefinition="text")
    private String url;

}