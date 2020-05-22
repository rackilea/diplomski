class Bob
{
public:
   virtual void foo() = 0;
}

class ActualBob : public Bob
{
public:
    void foo() override {/* I like foo things */}
}

class Jane
{
public:
    std::unique_ptr<Bob> bob;
}