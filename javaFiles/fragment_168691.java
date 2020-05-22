@InitBinder("question")
public void dataBinding(WebDataBinder binder){
    binder.registerCustomEditor(Set.class,"subjects", new CustomCollectionEditor(Set.class){
        @Override
        protected Object convertElement(Object element){
if (element!=null && element instanceof String){
                return  subjectService.getSubjectById(Long.parseLong((String)element));
            }
            return null;
        }
    });
}


@RequestMapping(value= "/questions/addQuestion", method = RequestMethod.POST)
public String addQuestion(@ModelAttribute("question") Question question,BindingResult result,Model model){

    if(question.getQuestionId() == 0){
        //new Subject, add it
        this.questionService.addQuestion(question);
    }else{
        //existing subject, call update
        this.questionService.updateQuestion(question);
    }

    return "redirect:/questions";

}