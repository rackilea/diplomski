@Repository("askBenefitsDAO")
public class AskBenefitsSSODaoImpl extends SSODaoImpl{
@Autowired 
    public AskBenefitsSSODaoImpl(JdbcTemplate jdbcTemplate){
    super(jdbcTemplate);
    }

}

public abstract class SSODaoImpl extends NamedParameterJdbcDaoSupport implements  SSODao{

    public SSODaoImpl(){

    }
    public SSODaoImpl(JdbcTemplate jdbcTemplate){
    super.setJdbcTemplate(jdbcTemplate);
    }
}