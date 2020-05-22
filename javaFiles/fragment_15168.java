public class YouBeanWithMsgReloadableResourceBundle {
    public void yourMethod(){
    String msg = ms.getMessage("your.memo.nic", null, "your default message", Locale.CANADA);
}

@Autowired MessageSource ms;}