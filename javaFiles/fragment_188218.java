@XmlRootElement(name = "itemBeans")
@XmlAccessorType(XmlAccessType.FIELD)
public class ItemBeans 
{
    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    private List<ItemBean> beans;

    public ItemBeans(List<ItemBean> beans) {
        this.beans = beans;
    }

    public ItemBeans() {
    }
}