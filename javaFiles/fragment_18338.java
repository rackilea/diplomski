require 'rubygems'
require 'socket'
require 'rocketamf'

class Animal
  attr_accessor :name, :age
end

# Map "Animal" in ruby to "Animal" in flash
RocketAMF::ClassMapper.define do |m|
  m.map :as => 'Animal', :ruby => 'Animal'
end

server = TCPServer.open(8081)
loop {
  client = server.accept

  animal = Animal.new
  animal.name = "Zebra"
  animal.age = 5
  client.write RocketAMF.serialize(animal, 3)

  client.close
}