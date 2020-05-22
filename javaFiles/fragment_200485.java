@Autowired
AnnotationMBeanExporter exporter;

@PostConstruct
public void init() {
    this.exporter.setNotificationListenerMappings(...);
}