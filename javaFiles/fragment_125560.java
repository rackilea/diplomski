package jerceka.workhard.demo;

public interface Repo extends CrudRepository<Account, Integer>{

    List<Account> findAllByName(String name);
}