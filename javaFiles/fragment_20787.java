class Transition {
    State from;
    Set<Condition> conditions;
    State to;
}

class State {
    String state;
}

class Condition {
    String condition;
}