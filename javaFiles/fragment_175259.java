public FirstMDP(double p1, double p2, double p3, double p4) {
    this.numStates = 6;
    this.dg = new GraphDefinedDomain(numStates);

    // actions for initial state 0
    ((GraphDefinedDomain) this.dg).setTransition(0,0,1,1.); //action a
    ((GraphDefinedDomain) this.dg).setTransition(0,1,2,1.); //action b
    ((GraphDefinedDomain) this.dg).setTransition(0,2,3,1.); //action c

    // actions for all the other states
    ((GraphDefinedDomain) this.dg).setTransition(1,0,1,1.); //action for state 1
    ((GraphDefinedDomain) this.dg).setTransition(2,0,4,1.); //action for state 2
    ((GraphDefinedDomain) this.dg).setTransition(3,0,5,1.); //action for state 3
    ((GraphDefinedDomain) this.dg).setTransition(4,0,2,1.); //action for state 4
    ((GraphDefinedDomain) this.dg).setTransition(5,0,5,1.); //action for state 5    

    this.domain = this.dg.generateDomain();
    this.initState = new GraphStateNode();  // Initial state is created
    ((GraphStateNode) this.initState).setId(0); // Initial state is initialized
    this.rf = new FourParamRF(p1,p2,p3,p4);
    this.tf = new NullTermination();
    this.hashFactory = new SimpleHashableStateFactory();
}