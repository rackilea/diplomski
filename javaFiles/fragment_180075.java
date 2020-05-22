auto populated_map()
{
    std::map<int, type> result;
    // ... populate map
    return result;
}

auto get_type(int id) -> const type&
{
    static const std::map<int, type> map = populated_map();
    return map.find(id)->second;
}