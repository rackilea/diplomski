// SWIGed C++
class IStringToBool
{
public:
    virtual bool call(std::string s) = 0;
}

class IStringToBoolUser
{
public:
    void setFunction(IStringToBool &function);
}