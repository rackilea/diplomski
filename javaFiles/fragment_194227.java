template <typename T, typename = void>
class AnimalFarm // Primary template
{
};

template<typename T>
class AnimalFarm<T*,
  std::enable_if_t<
     !std::is_same<T, Animal>::value &&
      std::is_base_of<Animal, T>::value
  >
> // Specialization only instantiated when both conditions hold
  // Otherwise SFINAE
  : public AnimalFarm<Animal*>
{
};