@Component
public class Writer2 implements ItemStreamWriter<SimpleObject>, org.springframework.batch.item.ItemWriter<SimpleObject>  {
    @Override
    public void write(List<? extends SimpleObject> list) throws Exception {
        for(SimpleObject simpleObject: list){
           // some logic 
        }
    }

    @Override
    public void open(ExecutionContext executionContext) throws ItemStreamException {

    }

    @Override
    public void update(ExecutionContext executionContext) throws ItemStreamException {

    }

    @Override
    public void close() throws ItemStreamException {

    }
}