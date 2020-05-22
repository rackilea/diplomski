public int method(TaskType t) {
    switch (t) {
    case TYPE_ONE: return 1;
    case TYPE_TWO: return 2;
    case TYPE_THREE: return 3;
    default:
       throw new AssertionError("TaskType " + t + " not implemented");
    }
    // not reachable ... no return required
}