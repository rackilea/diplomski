package controllers;

import...

@Controller
@RequestMapping(value = "/madLib")
public class MadLibController implements BeanDefinitionRegistryPostProcessor {
    @Autowired
    ApplicationContext context;

    ConfigurableListableBeanFactory beanFactory;

    private BeanDefinitionRegistry registry;

    public PartOfSpeech pos(String path){
        String input;
        try {
            input = utility.Util.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
            input = "v";
        }
        return new PartOfSpeech(input);
    }

    public MadLib ml(String path){
        String input;
        System.out.println(new File("").getAbsolutePath());
        try {
            input = utility.Util.readFile(path);
        } catch (IOException e) {
            e.printStackTrace();
            input = "v#V#v";
        }
        return new MadLib(input);
    }

    public void getBeansFromFiles() {
        File folder = new File("../../txt/ml");
        File[] listOfFiles = folder.listFiles();
        for (File file : listOfFiles){
            System.out.println("File path: " + file.getPath());
            MadLib ml = ml(file.getPath());
            String beanName = ml.getId();
            beanFactory.registerSingleton(beanName, ml);
            ((MadLib)beanFactory.getBean(beanName)).setId(ml.getId());
            ((MadLib)beanFactory.getBean(beanName)).setTitle(ml.getTitle());
            ((MadLib)beanFactory.getBean(beanName)).setAnswers(ml.getAnswers());
            ((MadLib)beanFactory.getBean(beanName)).setPrompts(ml.getPrompts());
            ((MadLib)beanFactory.getBean(beanName)).setStrings(ml.getStrings());
            ((MadLibList)beanFactory.getBean("madLibList")).getList().add(ml);
        }
        folder = new File("../../txt/pos");
        listOfFiles = folder.listFiles();
        for (File file : listOfFiles){
            System.out.println("File path: " + file.getPath());
            PartOfSpeech pos = pos(file.getPath());
            String beanName = pos.getId();
            beanFactory.registerSingleton(beanName, pos);
            ((PartOfSpeech)beanFactory.getBean(beanName)).setName(pos.getName());
            ((PartOfSpeech)beanFactory.getBean(beanName)).setWords(pos.getWords());
        }
    }


    @GetMapping
    public String links(Model model){
        MadLibList list = (MadLibList)beanFactory.getBean("madLibList");
        model.addAttribute("madLibList", list);
        return "madLibLinks";
    }

    @GetMapping("/{name}")
    public String prompts(HttpServletRequest req, HttpServletResponse res, 
            Model model, @PathVariable("name") String name, 
            @RequestParam(value = "random", defaultValue = "false") String random){
        MadLib madLib = (MadLib)beanFactory.getBean(name);
        //System.out.println(madLib);
        madLib.setAnswers(new ArrayList<String>(madLib.getPrompts().size()));
        System.out.println("Answers: " + madLib.getAnswers());
        if (random.equals("true")){
            System.out.println("Prompts: " + madLib.getPrompts());
            for (int i=0; i<madLib.getPrompts().size(); i++){
                try {
                    String posBean = utility.Util.camelCase(madLib.getPrompts().get(i));
                    PartOfSpeech pos = (PartOfSpeech)beanFactory.getBean(posBean);
                    String word = pos.getWord();
                    System.out.println(word);
                    madLib.getAnswers().add(word);
                } catch (Exception e) {
                    System.out.println("exception in randomizing answers for " + madLib.getPrompts().get(i));
                    System.out.println(e);
                    e.printStackTrace();
                    madLib.getAnswers().add("");
                }
            }
        }
        model.addAttribute("default", "");
        model.addAttribute("madLib", madLib);
        return "madLibPrompts";
    }

    @PostMapping(value = "/result")
    public String result(Model model, @ModelAttribute("madLib") MadLib madLib, BindingResult result){
        System.out.println(madLib.getAnswers().get(0));
        //model.addAttribute(madLib);
        return "madLibResult";
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory arg0) throws BeansException {
        this.beanFactory = arg0;
        getBeansFromFiles();
    }

    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry arg0) throws BeansException {
        this.registry = arg0;
    }



}