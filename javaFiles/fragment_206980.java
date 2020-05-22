import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RCMatchDaoImplTest.TestConfig.class, loader = AnnotationConfigContextLoader.class)
public class RCMatchDaoImplTest {

    @Autowired
    private RCMatchDaoImpl service;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private Logger logger;

    private RemitBean remitBean;
    private List<RemitBean> remitBeanList;
    private BigDecimal depositPostedAmt, claimPostedAmt, remitAmount;
    private ClaimVO claim;
    private List<ClaimVO> claims;


    @Before
    public void setUp() throws NoSuchFieldException, SecurityException, Exception {
        /* Set dependencies*/
        service.setJdbcTemplate(jdbcTemplate);
        setFinalStatic(RCMatchDaoImpl.class.getDeclaredField("logger"), logger);

        remitBean = new RemitBean();
        remitBeanList = new ArrayList<>();
        claim = new ClaimVO();
        claims = new ArrayList<>();

        remitBeanList.add(remitBean);
        depositPostedAmt = new BigDecimal(-10);
        claimPostedAmt = new BigDecimal(-10);
        remitAmount = new BigDecimal(20);
        claims.add(claim);
    }

    private static void setFinalStatic(Field field, Object newValue) throws Exception {
        field.setAccessible(true);
        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);
        field.set(null, newValue);
    }

    @Test
    public void testLucenePost_refund_success() throws SQLException {

        /* Set Data */
        remitBean.setRemitType("R");
        remitBean.setRemitAmt(remitAmount);
        remitBean.setDepositId(6866418);
        remitBean.setClaims(claims);

        depositPostedAmt = depositPostedAmt.add(new BigDecimal(20));
        claimPostedAmt = claimPostedAmt.add(new BigDecimal(10));


        claim.setClaimId(6866418);

        claim.setContractNum("100");

        Object[] depositParams = new Object[]{6866418};
        Object[] claimParams = new Object[]{6866418, "100"};

        /* Record Invocations*/

        when(jdbcTemplate.queryForObject(eq(Constants.FETCH_DEPOSIT_POSTED_AMT), eq(BigDecimal.class), anyVararg())).thenReturn(depositPostedAmt);
        when(jdbcTemplate.queryForObject(eq(Constants.FETCH_CLAIM_POSTED_AMOUNT), eq(BigDecimal.class), anyVararg())).thenReturn(claimPostedAmt);
        doNothing().when(logger).error(anyString());

        /* Play the Service */
        service.lucenePost(remitBeanList);

        /* Verify Results */

        /* reset data to original value as in SetUp method*/
    }

    @Configuration
    public static class TestConfig {

        @Mock
        JdbcTemplate jdbcTemplate;

        @Mock
        Logger logger;

        TestConfig() {
            MockitoAnnotations.initMocks(this);
        }

        @Bean
        public RCMatchDaoImpl getRCMatchDaoImpl() {
            return new RCMatchDaoImpl();
        }

        @Bean
        public JdbcTemplate jdbcTemplate() {
            return jdbcTemplate;
        }

        @Bean
        public Logger logger() {
            return logger;
        }
    }

    public static class RCMatchDaoImpl {

        public static final Logger logger = LoggerFactory.getLogger(RCMatchDaoImpl.class);

        private JdbcTemplate jdbcTemplate;

        public void setJdbcTemplate(final JdbcTemplate jdbcTemplate) {
            this.jdbcTemplate = jdbcTemplate;
        }

        public void lucenePost(final List<RemitBean> remitBeanList) {
            for (RemitBean remitBean : remitBeanList) {
                System.out.println(jdbcTemplate.queryForObject(Constants.FETCH_DEPOSIT_POSTED_AMT, BigDecimal.class, new Object[]{remitBean.getDepositId()}));
                for (ClaimVO claimVO : remitBean.getClaims()) {
                    System.out.println(jdbcTemplate.queryForObject(Constants.FETCH_CLAIM_POSTED_AMOUNT, BigDecimal.class, new Object[]{claimVO.getClaimId(), remitBean.getContractNum()}));
                }
            }
        }
    }

    public static class RemitBean {

        private String remitType;
        private BigDecimal remitAmt;
        private int depositId;
        private List<ClaimVO> claims;
        private Object contractNum;

        public void setRemitType(final String remitType) {
            this.remitType = remitType;
        }

        public void setRemitAmt(final BigDecimal remitAmt) {
            this.remitAmt = remitAmt;
        }

        public void setDepositId(final int depositId) {
            this.depositId = depositId;
        }

        public int getDepositId() {
            return depositId;
        }

        public void setClaims(final List<ClaimVO> claims) {
            this.claims = claims;
        }

        public List<ClaimVO> getClaims() {
            return claims;
        }

        public Object getContractNum() {
            return contractNum;
        }
    }

    public static class ClaimVO {

        private int claimId;
        private String contractNum;

        public void setClaimId(final int claimId) {
            this.claimId = claimId;
        }

        public int getClaimId() {
            return claimId;
        }

        public void setContractNum(final String contractNum) {
            this.contractNum = contractNum;
        }
    }

    static class Constants {
        public static final String FETCH_DEPOSIT_POSTED_AMT = "1";
        public static final String FETCH_CLAIM_POSTED_AMOUNT = "2";
    }
}