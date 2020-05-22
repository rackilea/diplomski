@XmlRootElement(name = "MyNotes")
public class MyNotes {

    private List<MyNote> myNotes = new ArrayList<>();

    public MyNotes() {
    }

    public List<MyNote> getMyNotes() {
        return myNotes;
    }

    @XmlElement(name = "note")
    public void setMyNotes(List<MyNote> myNotes) {
        this.myNotes = myNotes;
    }

    public void add(MyNote myNote) {
        myNotes.add(myNote);
    }

    @Override
    public String toString() {
        StringBuffer str = new StringBuffer();
        for (MyNote note : this.myNotes) {
            str.append(note.toString());
        }
        return str.toString();
    }

}