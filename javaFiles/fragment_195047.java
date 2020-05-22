@ConfigureTimeout(timeout = 100)
@Cacheable(value = "supplierConfigResponse", key = "#key")
public String test(String key){
    //your logic
    return null;
}