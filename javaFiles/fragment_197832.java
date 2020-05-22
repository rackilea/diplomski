@RunWith(CdiRunner.class)
public class LdapTest extends TestCase {
    public static final Logger LOGGER =     LoggerFactory.getLogger(LdapTest.class);
    public static final String DOMAIN_DSN = "dc=my.domain";
    public static final String LDIF_FILE = "agents.ldif";
    public static final String BPM_SCHEMA = "schema.ldif";

    @Inject
    private LDAPManager ldapManager;

    private EmbeddedLdapRule embeddedLdapRule = EmbeddedLdapRuleBuilder.newInstance()
        .usingDomainDsn(DOMAIN_DSN)
        .importingLdifs(LDIF_FILE)
        .withSchema(BPM_SCHEMA)
        .build();

    @Rule
    public EmbeddedLdapRule getLdapRule() {
        return embeddedLdapRule;
    }

    @Test
    public void getAgent() throws Exception {
        embeddedLdapRule.ldapConnection();
        DirContext dirContext = embeddedLdapRule.dirContext();
        ldapManager.setContext(dirContext);
        assertNotNull(ldapManager.getAgent("123"));
    }
}