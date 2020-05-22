@Service("articleService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ArticleServiceImpl implements ArticleService {

  @Autowired
  private ArticleDao articleDao;


  public ArticleServiceImpl() {
     //default constructor required for @Autowired
  }

  public ArticleServiceImpl() {
  }

  @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
  public void addArticle(Article article) {
    articleDao.saveArticle(article);
  }
}