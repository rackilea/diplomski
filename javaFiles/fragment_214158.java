@Configuration
public Option[] config() {

    return options(         
        bundle("reference:file:target/classes"),
        junitBundles(),
        felix()
        );
}