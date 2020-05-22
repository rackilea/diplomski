package database.mariadb.persistence;

import database.mariadb.model.Contact;

import java.util.List;

/**
 * Created by Michael
 * Creation date 3/21/2017.
 * @link
 */
public interface ContactRepository {

    List<Contact> findAll();
    void insert(Contact contact);
}