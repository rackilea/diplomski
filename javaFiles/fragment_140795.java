package models.test;

import play.db.ebean.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by aakture on 3/7/14.
 */
@Entity
public class Person extends Model {
    @Id
    long id;

    @OneToMany(cascade = CascadeType.ALL)
    List<Keyword> keywords = new ArrayList();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Keyword> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<Keyword> keywords) {
        this.keywords = keywords;
    }

    public static Finder<Integer, Person> find = new Finder<Integer, Person>(
            Integer.class, Person.class);
}

package models.test;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Keyword extends Model {

    @Id
    Integer id;

    String text;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    public static Finder<Integer, Keyword> find = new Finder<Integer, Keyword>(
            Integer.class, Keyword.class);

}

package models.test;

import play.db.ebean.Model;

import javax.persistence.*;
import java.sql.Date;
@Entity
public class Tweet extends Model {

    @Id
    Integer id;

    Date datetime;

    @OneToOne
    Keyword keyword;

    public void setId(Integer id) {
        this.id = id;
    }

    public Keyword getKeyword() {
        return keyword;
    }

    public void setKeyword(Keyword keyword) {
        this.keyword = keyword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public static Finder<Integer, Tweet> find = new Finder<Integer, Tweet>(
            Integer.class, Tweet.class);

}

    @Test
    public void testTweets() {
        List<Keyword> keywordList = new ArrayList<Keyword>();
        Keyword keyword = new Keyword();
        keyword.setText("hello");
        keywordList.add(keyword);

        keyword = new Keyword();
        keyword.setText("world");
        keywordList.add(keyword);
        Person person = new Person();
        person.setKeywords(keywordList);
        person.save();

        keyword  = Keyword.find.where().eq("text", "hello").findUnique();
        log.info("keywords " + keyword);
        java.sql.Date now = new java.sql.Date(new Date().getTime());
        for(int i = 0; i < 10; i++) {
            Tweet tweet = new Tweet();
            tweet.setKeyword(keyword);
            tweet.setDatetime(now);
            tweet.save();
        }
        log.info("now is        " + now.getTime());
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -7);
        java.sql.Date oneHourAgo = new java.sql.Date(cal.getTimeInMillis());
        log.info("oneHourAgo is " + oneHourAgo.getTime());
        List<Keyword> personsKeywords = person.getKeywords();
        List<String> keyWordsStringList = new ArrayList<String>();
        for(Keyword kw : keywordList) {
            keyWordsStringList.add(kw.getText());
        }
        List<Tweet> tweets = Tweet.find.where().and(Expr.in("keyword.text", keyWordsStringList), Expr.gt("datetime", oneHourAgo)).findList();
        log.info("tweets has " + tweets.size());
    }