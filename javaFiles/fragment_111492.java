// %inline = wrap and define at the same time
%inline %{
  const Interface& find_interface(const std::string& key) {
    static class TestImpl : public Interface {
      virtual std::string foo() const {
        return "Hello from C++";
      }
    } inst;
    return inst;
  }
%}