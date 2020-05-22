public class MyBaseClass {
private MypropConfigProperties mypropConfigProperties;

@Autowired
public void setMyProp(MypropConfigProperties mypropConfigProperties) {
this.mypropConfigProperties= mypropConfigProperties;
}
.....
log.info(this.mypropConfigProperties.getMyProp().toString()); // this does the final magic
....