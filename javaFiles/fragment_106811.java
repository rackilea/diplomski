public class MainView  implements IMainView { 

    private MainPresenter _presenter; 

    public MainView() { 
        _presenter = beanFactory.getBean("MainPresenter", this); 
    }  
}