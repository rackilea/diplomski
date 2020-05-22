class Uploader
{
private:
    Parser parser_;
    Persistence persistence_;

    void upload() {
        parser_.read();
        parser_.parse();
        parser_.validate();
        persistence_.persist(parser_.getData());
    }

public:
    void setParser(Parser parser) {parser_ = parser;}
    void setPersister(Persistence persistence) {persistence_ = persistence;}
};

Class Parser
{
    abstract void read();
    abstract void parse();
    abstract void validate();
    abstract String getData();
};

class Persistence
{
    abstract persist(String data);
};

class CsvParser : public Parser
{
    // implement everything here
};

// more Parser implementations as needed

class DbPersistence : public Persistence
{
    // implement everything here
};

class NwPersistence : public Persistence
{
    // implement everything here
};

// more Persistence implementations as needed