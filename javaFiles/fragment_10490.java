// PersonExternalizedSqlDAO.java

package com.daoexp.dao;

@@ExternalizedSqlViaStringTemplate3
@RegisterMapper(PersonMapper.class)
public interface PersonExternalizedSqlDAO {
    @SqlQuery
    List<Person> getPersonByNames(@BindIn("names") List<String> names);
}