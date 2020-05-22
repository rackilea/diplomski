@Component
public class MyBean {

    public List<LocalDate> processData(Exchange exchange) {
        return Lists.newArrayList(LocalDate.now(),
                   LocalDate.now().minusYears(1L));
   }
}