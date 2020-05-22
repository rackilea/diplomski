import static org.springframework.ui.freemarker.FreeMarkerTemplateUtils.processTemplateIntoString;

@Component
public class AlertMailComposer implements Processor {

    public static final String TEMPLATE = "AlertMail.ftl";

    @Autowired
    private Configuration freemarkerConfiguration;

    protected String composeHtml(Alert alert) throws IOException, TemplateException {
        return processTemplateIntoString(freemarkerConfiguration.getTemplate(TEMPLATE), ImmutableMap.of(
                "alertType", alert.getAlertType(),
                "message", alert.getMessage(),
                "nodeName", alert.getEvent().getNodeName(),
                "event", toJson(alert.getEvent(), true)
        ));
    }
...