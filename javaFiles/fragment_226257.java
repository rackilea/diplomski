class VehiclePart

class Wheel extends VehiclePart

class Engine extends VehiclePart

class Vehicle {
  Wheel[] wheel
}

class PoweredVehicle extends Vehicle {
   Engine: engine
}

class Bicyle extends Vehicle 

class Car extends PoweredVehicle

class Truck extends PoweredVehicle