class SchemaExample 
{
    interface Schema 
    {
        // methods go here
    }

    interface SchemaParser 
    {
        Schema parseSchema();
    }

    class SimpleSchema implements Schema 
    {
        // implementation of Schema's methods
    }

    class SimpleSchemaParser implements SchemaParser 
    {
        @Override
        public SimpleSchema parseSchema() 
        {
            // real business logic here...
            return new SimpleSchema();
        }   
    }

    void usage() 
    {
        SimpleSchema schema = new SimpleSchemaParser().parseSchema();
    }
}