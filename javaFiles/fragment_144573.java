template<unsigned Start>
struct sum_from{
  template<unsigned Goal>
  struct to{
    template<unsigned N>
    struct equals;

    typedef equals<adder<Start, Goal>::value> result;
  };
};

int main(){
  sum_from<1>::to<1000>::result();
}