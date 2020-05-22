@Component
public class Home {

    private Parameter param;

    @Cacheable(cacheName = "homeCache", 
                    keyGenerator = @KeyGenerator(name = "com.myapp.cache.Home.ParamKeyGenerator"))

    public Result getPerson(Person p) {

        //Do something with p
        return result;
    }

    public Parameter getParam() {

        return param;
    }

    public void setParam(Parameter param) {

        this.param = param;
    }

    public static class ParamKeyGenerator implements CacheKeyGenerator<Serializable> {

        public Serializable generateKey(MethodInvocation methodInvocation) {

            Object[] obj = methodInvocation.getArguments();
            Home h = (Home) methodInvocation.getThis();

            return this.generateKey(obj[0], h.getParam());
        }

        public Serializable generateKey(Object... data) {

            String key = ((Person) data[0]).getName() + ((Parameter) data[1]).getName();
            System.out.println("generating key: " + key);
            return key;
        }
    }
}