require 'java'

Dir.glob("C:/MyCustomLibraries/MATLAB/*.jar").each do |jar_file| #Has all MPLab jars except org.netbeans.*
  $CLASSPATH << jar_file
  require jar_file
end

module Mplab
  include_package "org.openide.util" #Lookup
  include_package "com.microchip.mplab.mdbcore.simulator" #PinSet, Simulator
  include_package "com.microchip.mplab.mdbcore.assemblies" #Assembly, AssemblyFactory
end

assembly_factory = Mplab::Lookup.getDefault.lookup(Mplab::AssemblyFactory.java_class)
assembly = assembly_factory.create("PIC18F14K50")
simulator = assembly.getLookup.lookup(Mplab::Simulator.java_class)
num = simulator.getDataStore.getProcessor.getPinSet.getNumPins
puts "pins: #{num}"