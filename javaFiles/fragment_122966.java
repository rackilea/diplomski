@Root(name = "Question")
@Convert( value = Question.QuestionConvert.class)
public class Question
{
    @Attribute(name = "ID", required = true)
    private String id;
    @Element(name = "text")
    private String text;
    @ElementList(inline = true)
    private ArrayList<Criteria> criteria;


    public Question(String id)
    {
        this.id = id;
        this.criteria = new ArrayList<>();

        this.text = "This inner text ...";
    }

    private Question() { }


    // ...


    @Override
    public String toString()
    {
        return "Question{" + "id=" + id + ", text=" + text + ", criteria=" + criteria + '}';
    }



    static class QuestionConvert implements Converter<Question>
    {
        private final Serializer ser = new Persister();


        @Override
        public Question read(InputNode node) throws Exception
        {
            Question q = new Question();
            q.id = node.getAttribute("ID").getValue();
            q.text = node.getValue();

            q.criteria = new ArrayList<>();
            InputNode criteria = node.getNext("Criteria");

            while( criteria != null )
            {
                q.criteria.add(ser.read(Criteria.class, criteria));
                criteria = node.getNext("Criteria");
            }

            return q;
        }


        @Override
        public void write(OutputNode node, Question value) throws Exception
        {
            node.setAttribute("ID", value.id);
            node.setValue(value.text);


            for( Criteria c : value.getCriteria() )
            {
                ser.write(c, node);
            }
        }
    }
}