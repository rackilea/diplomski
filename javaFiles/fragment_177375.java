package controllers;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import javax.inject.Inject;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class TestingReportsDep{

private JPAApi jpaApi;
@Inject
public TestingReportsDep(JPAApi jpaApi) {
    this.jpaApi = jpaApi;
}
Object[] tempObj;

@Transactional
public void resolving_requests) {
    String id_column = "id", city_column = "city", streetname_column ="streetname", housenumber_column = "housenumber"; //Parameters
    String request="SELECT "+id_column+","+streetname_column+" FROM address;";
    jpaApi.withTransaction(entityManager -> {
        Query query = entityManager.createNativeQuery(request);
        int ResultsAmount = query.getResultList().size();
        List Result = query.getResultList();
        System.out.print("\n\n\nNew super query by Bogdan:\n");

        for(int i=0; i< ResultsAmount; i++){
            tempObj = (Object[]) Result.get(i);

            System.out.print(tempObj[0]+" "+tempObj[1]+"\n");
        }
        return null;
    });
 }
}