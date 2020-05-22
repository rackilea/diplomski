@Bean("Channel1") 
@BridgeTo("Channel1and2")
PollableChannel c1() {...}

@Bean("Channel2") 
@BridgeTo("Channel1and2")
PollableChannel c2() {...}