package net.mperon.cdi.extension;

    public class MyExtension implements Extension {

    private static final Logger log = LoggerFactory.getLogger(MyExtension.class);

    public <T> void processAnnotatedType(@Observes ProcessAnnotatedType<T> pat) {
        AnnotatedType<T> at = pat.getAnnotatedType();

        //if dont have you anotation, just continue
        if(!at.isAnnotationPresent(HttpSecurity.class)) {
            return;
        }

        //here you can read all annotation from object and do whatever you want:
        log.info("class: {}", at.getJavaClass());
        log.info("constructors: {}", at.getConstructors());
        log.info("fields: {}", at.getFields());
        log.info("methods: {}", at.getMethods());

        //and so more...

    }