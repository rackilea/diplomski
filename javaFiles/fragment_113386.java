trait HasStomach {
  var stomachContent: Double
  def eat(food: Food) = ...
}
class Horse extends HasStomach
class Dog extends HasStomach