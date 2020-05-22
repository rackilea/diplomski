@SpringBootApplication
@ComponentScan({"com.mycompany.service", "com.mycompany.interceptors","com.mycompany.manager"})
@PropertySource("file:config/application.properties")
public class ParentConfig{

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .parent(ParentConfig.class)
                .child(ChildConfig1.class, ChildConfig2.class, ChildConfig3.class, ..., ChildConfigN.class)
                .run(args);
    }

    (...)

}