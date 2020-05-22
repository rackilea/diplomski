@RestController
@FeignClient(name = "zuul-server")
public interface ProxyImages {

    @Configuration
    class MultipartSupportConfig {

        @Autowired
        private ObjectFactory<HttpMessageConverters> messageConverters;

        @Bean
        @Primary
        @Scope("prototype")
        public Encoder feignFormEncoder() {
            return new SpringFormEncoder(new SpringEncoder(messageConverters));
        }
    }

    @RequestMapping(value = {"oauth2-server/auth/user/avatar"}, consumes = {"multipart/form-data"})
    ResponseEntity<String> saveUserAvatar(@RequestPart(name = "file") MultipartFile file);
}