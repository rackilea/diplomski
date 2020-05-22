@Scope("step")
public class MyMongoItemReader extends MongoItemReader<Object> {

    public void setCollection(String collection) {
        this.collection = collection;
    }

    @Override
    protected Iterator<Object> doPageRead() {

        ...
        Query mongoQuery = // set query
        ...

        return (Iterator<Object>) //
           template.find(mongoQuery, Object.class, this.collection).iterator();
    }

}