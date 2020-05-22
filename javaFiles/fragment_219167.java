if (first instanceof Composite){
    Composite comp = (Composite)first;
    // use "comp" here: 
    for(Component c : comp.caseComponents){
             q.add(c);
    }
}