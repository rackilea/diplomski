@ManagedBean(name = "bean")
@SessionScoped
public class Bean {
private List<Integer> numList;

public List<Integer> getNumList() {
    return numList;
}

public void setNumList(List<Integer> numList) {
    this.numList = numList;
}

public Bean() {
    numList=new ArrayList<Integer>();
    for (int i = 0; i < 10; i++) {
        numList.add((int)(Math.random()*100));
    }
}

}