class types
{
private:
    std::once_flag _flag;
    std::map<int, type> _map;
public:
    auto get_type(int id) -> const type&
    {
        std::call_once(_flag, [this] { _map = populated_map(); });
        return _map.find(id)->second;
    }
};