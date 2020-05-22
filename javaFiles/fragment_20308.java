public class TestUDF implements UDF1<String, String> {

@Override
public String call(String customer) throws Exception {

    return customer + "123";
}

}