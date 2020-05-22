@RequestMapping("/question")
public class QuestionController
{
  @RequestMapping("/detail/{questionId}")
  public ModelAndView detail(@PathVariable("questionId") long questionId,    HttpServletRequest request, HttpServletResponse response) throws Exception{

}