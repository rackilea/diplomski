package ru.model;

import javax.persistence.*;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Entry implements Serializable {
    private static final long serialVersionID = 8201337883209943936L;

    private Integer primary_id;
    private Integer id;
    private String description;
    private Integer votes;
    private String author;
    private Date date;
    private String gifURL;
    private String previewURL;
    private String embedId;
    private String type;

//  getters and setters
}