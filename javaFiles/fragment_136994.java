@Service
@Qualifier("service1")
public interface SuperCoolService implements CoolService {

    public Object resolve(int attribute){...}
}

@Service
@Qualifier("service1")
public interface UltraCoolService implements CoolService {

    public Object resolve(int attribute){...}
}