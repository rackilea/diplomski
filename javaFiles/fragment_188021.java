public AbstractClass(Prop prop) {
    this.prop = prop;
    prop.getName();
} 
...
@Autowired
public DefaultClass(Prop prop) {
    super(prop);
}