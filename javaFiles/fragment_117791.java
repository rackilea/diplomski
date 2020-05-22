interface Product {}

interface ComputerProduct extends Product {}
class ComputerPart implements ComputerProduct  {}
class Peripheral implements ComputerProduct  {}

interface PartyTrayProduct extends Product {}
class Cheese implements PartyTrayProduct{} 
class Fruit implements PartyTrayProduct{}

class Service implements Product {} 
class DeliveryService implements PartyTrayProduct{} 
class AssemblyService implements ComputerProduct  {}