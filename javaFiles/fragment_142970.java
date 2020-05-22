@Service
public class EcacheSpringtest {

@Cacheable(cacheName = "messageCache")
String getName(String name) {
 System.out.println(name+ " "+"has not been found in the cache so called getName()");
 return "testObject";
}

}