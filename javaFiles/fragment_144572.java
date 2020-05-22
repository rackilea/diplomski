template<unsigned Cur, unsigned Goal>
struct adder{
  static unsigned const sub_goal = (Cur + Goal) / 2;
  static unsigned const tmp = adder<Cur, sub_goal>::value;
  static unsigned const value = tmp + adder<sub_goal+1, Goal>::value;
};

template<unsigned Goal>
struct adder<Goal, Goal>{
  static unsigned const value = Goal;
};