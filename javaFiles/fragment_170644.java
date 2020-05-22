import javax.persistence.EntityManager;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

public CustomEntity getEntity(){
        Query<CustomEntity> q = (Query<CustomEntity>) entityManager.createQuery("select 
                         e.id,e.name from CustomEntity e where e.name = 'parameter'");
        q.setResultTransformer(Transformers.aliasToBean(CustomEntity.class));
        CustomEntity entity = (CustomEntity) q.getSingleResult();
        return name;
    }