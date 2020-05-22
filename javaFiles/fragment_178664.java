package org.nkl.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "MESSAGES")
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "MESSAGE_ID")
    private Long id;
    @Column(name = "MESSAGE_TEXT")
    private String text;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "NEXT_MESSAGE")
    private Message nextMessage;

    public Message(String text) {
        this.text = text;
    }

    Message() {}

    // setters/getters not shown.

}