@Component("transformationBuilder")
@Scope("prototype")
public class TransformationBuilder implements Runnable,
        SourceNotificationCallback, TargetNotificationCallback,
        ApplicationContextAware {

   // either use the value of the property 'some.property.key' or 5 as default
   @Value("${some.property.key:5}")
   int test;

   @Autowired
   @Qualifier("desktopBuilderCallback")
   BuilderCallback builderCallback;

   ...
}