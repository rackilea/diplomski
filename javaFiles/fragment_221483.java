import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(MyWrapperForList.class, Expense.class);

        //UNMARSHALLING
        Unmarshaller unmarshaller = jc.createUnmarshaller();

        StreamSource xml = new StreamSource("src/forum18594548/nub.xml");
        MyWrapperForList<Expense> wrapper = (MyWrapperForList<Expense>) unmarshaller.unmarshal(xml, MyWrapperForList.class).getValue();
        List<Expense> data = wrapper.getItems();

        System.out.println(data.getClass());
        for(Expense expense : data) {
            System.out.println(expense);
        }
   }

}