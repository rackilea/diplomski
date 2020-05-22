@Local(ISqlSessionFactoryProvider.class)
@Stateless
public class SqlSessionFactoryProvider implements ISqlSessionFactoryProvider


@Local
public interface ISqlSessionFactoryProvider {

    SqlSessionFactory produceFactory() throws IOException;

}