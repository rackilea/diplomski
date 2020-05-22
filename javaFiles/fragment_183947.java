import com.alibaba.fastjson.JSON;
import com.example.SpringUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.spi.BackendIdConverter;
import org.springframework.stereotype.Component;

import javax.persistence.EmbeddedId;
import javax.persistence.Id;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Component
public class CustomBackendIdConverter implements BackendIdConverter {

    @Override
    public boolean supports(Class<?> delimiter) {
        return true;
    }

    @Override
    public Serializable fromRequestId(String id, Class<?> entityType) {
        if (id == null) {
            return null;
        }

        //first decode url string
        if (!id.contains(" ") && id.toUpperCase().contains("%7B")) {
            try {
                id = URLDecoder.decode(id, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        //deserialize json string to ID object
        Object idObject = null;
        for (Method method : entityType.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Id.class) || method.isAnnotationPresent(EmbeddedId.class)) {
                idObject = JSON.parseObject(id, method.getGenericReturnType());
                break;
            }
        }

        //get dao class from spring
        Object daoClass = null;
        try {
            daoClass = SpringUtil.getBean(Class.forName("com.example.db.dao." + entityType.getSimpleName() + "DAO"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //get the entity with given primary key
        JpaRepository simpleJpaRepository = (JpaRepository) daoClass;
        Object entity = simpleJpaRepository.findOne((Serializable) idObject);
        return (Serializable) entity;

    }

    @Override
    public String toRequestId(Serializable id, Class<?> entityType) {
        if (id == null) {
            return null;
        }

        String jsonString = JSON.toJSONString(id);

        String encodedString = "";
        try {
            encodedString = URLEncoder.encode(jsonString, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodedString;
    }
}