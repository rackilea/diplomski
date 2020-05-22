@Autowired
GroupConverter groupConverter;

@Override
public void addFormatters(FormatterRegistry registry) {
    registry.addConverter(groupConverter);
}