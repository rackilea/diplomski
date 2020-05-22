package com.test.company
@Component
@RestController
public class CustomerSignUpService {

   @Autowired
   private MongoTemplate mongoTemplate;

   @Autowired
   private Environment env;

   ...
   ...
}