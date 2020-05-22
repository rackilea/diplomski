import static org.springframework.data.mongodb.core.query.Criteria.where;  
import static org.springframework.data.mongodb.core.query.Query.query;  
import static org.springframework.data.mongodb.core.query.Update.update; 

@Controller
public class PersonController {

@Autowired
private MongoTemplate mongoTemplate;

@Autowired
MongoOperations  mongoOperations;

...

mongoOperations.updateFirst(query(where("_id").is(person.getId())), Update.update("name", newPersonName),"Person");