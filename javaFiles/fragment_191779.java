%extend {
  function<Ret(__VA_ARGS__)>(Name##Impl *in) {
    return new std::function<Ret(__VA_ARGS__)>([=](auto&& ...param){
      return in->call(std::forward<decltype(param)>(param)...);
    });
  }
}