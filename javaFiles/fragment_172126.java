abstract class State {
  abstract void instructionResponseRecievedFromAgent();
}

class State1 extends State {
  void instructionResponseRecievedFromAgent() {
    // instance variable
    agent.instructionResponseRecievedFromAgentFromState1();
  }
}

class State1 extends State {
  void instructionResponseRecievedFromAgent() {
    // instance variable
    agent.instructionResponseRecievedFromAgentFromState2();
  }
}