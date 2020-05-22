public class InputDatabaseServiceImpl implements InputDatabaseService {


   @Autowired
   public ArticleService articleService;

   public InputDatabaseServiceImpl(){
      //no need of arguments constructor
   }

   public int inputArticle(Article article) {
      articleService.saveArticle(article);
      return 0;
   }

}