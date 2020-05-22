@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "listof_aaa",
    "listof_bbb",
    "listof_ccc",
    "listinside"
})
@XmlRootElement(name = "root")
public class Root {

    @XmlElement(required = true)
    protected Listof_aaa listof_aaa;
    protected Listof_bbb listof_bbb;
    protected Listof_ccc listof_ccc;
    protected java.util.List<Listinside> listinside // example of multiple elements with one node name under the root

    public Listof_aaa getListof_aaa() {
      return listof_aaa;
    }

    public void setListof_aaa(Listof_aaa value) {
      this.listof_aaa = value;
    }

    // other getters and setters
    // and an example of multiple elements under the root

    public java.util.List<Listinside> getListinside() {
    if (listinside == null) {
        listinside = new ArrayList<Listinside>();
    }
    return this.sec;
}
}