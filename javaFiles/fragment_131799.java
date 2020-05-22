package demo;

import com.fasterxml.jackson.annotation.JsonView;

public class Album {

    @JsonView(Views.Public.class)
    private String id;

    @JsonView(Views.Public.class)
    private String title;

    @JsonView(Views.Public.class)
    private String artist;

    @JsonView(Views.Internal.class)
    private String secret;

    public Album(String id, String title, String artist, String secret) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.secret = secret;
    }

}