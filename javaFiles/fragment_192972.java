@ControllerAdvice
public class CommonDataControllerAdvice {
    @Autowired
    private CommonDataHolder holder;

    public void setCommonDataHolder(CommonDataHolder holder) {
        this.holder = holder;
    }

    @ModelAttribute("menu")
    public Menu menu() {
        return holder.getMenu();        
    }

    @ModelAttribute("footer")
    public Footer footer() {
        return holder.getFooter();
    }
}