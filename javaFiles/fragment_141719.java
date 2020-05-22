int myRecursiveMethod() {

    ...

    // Base case
    if (someCondition) { return 1; }

    // Otherwise
    return myRecursiveMethod() + myRecursiveMethod() + 1;
}


int totalCount = myRecursiveMethod();