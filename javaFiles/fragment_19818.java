import models.Result;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 *
 */
public class Main {
    private static SqlSessionFactory sessionFactory = null;
    private static String CONFIGURATION_FILE = "mybatis-config.xml";

    static {
        try {
            Reader reader = Resources.getResourceAsReader(CONFIGURATION_FILE);
            sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {

        SqlSession session = sessionFactory.openSession();

        Result res = new Result();

        res.start_from = 5;

        Object obj = session.selectOne("select_4", res);

        // `obj` must be NULL
        // `res` contains all the results of Oracle procedure call
    }
}