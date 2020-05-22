public class InformationService {

    @Autowired
    ElementDao elementDao;
    @Autowired
    InformationDao infoDao;

    @Transactional
    public void init() {
        List<Element> elements = new ArrayList<>();
        Element element1 = new Entity("test", "description");
        Element element2 = new User("test2");
        Element element3 = new Entity("test3", "description");
        Element element4 = new User("test4");

        elements.add(element1);
        elements.add(element2);
        elements.add(element3);
        elements.add(element4);

        elementDao.save(elements);

        Information info = new Information("some text", elements);
        infoDao.save(info);

        List<Element> elements2 = new ArrayList<>();

        Element element5 = elementDao.findById(element1.getId());
        Element element6 = elementDao.findById(element2.getId());
        Element element7 = elementDao.findById(element3.getId());
        Element element8 = elementDao.findById(element4.getId());
        elements2.add(element5);
        elements2.add(element6);
        elements2.add(element7);
        elements2.add(element8);
        elementDao.save(elements2);
        Information info2 = new Information("@ something else @", elements2);

        //failTransaction();
        infoDao.save(info2);
    }


    public void failTransaction() {
        throw new RuntimeException("transaction failed");
    }
}