int state = 0; //1 - locked, 0 - unlocked

routine lock:
    while state.cas(new_value=1, wanted_value=0) == false //if state is 0 (unlocked), store 1 (locked) and return true, otherwise just return false.
       yield

routine unlock:
    atomic_store(state,0)