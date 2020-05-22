tree grammar protocolWalker;

options {
  language = Java;
  tokenVocab = protocol;   
  ASTLabelType = CommonTree;
}    


@header {
    package com.javadude.antlr3.x.tutorial;
    import java.util.List;
    import java.util.ArrayList;
}

@members { 
  //stores all the transitions objects as they get processed
  private ArrayList<Transitions> allTransitions = new ArrayList<Transitions>();

  //returns all the transitions
  public List<Transitions> getAllTransitions() { 
    return allTransitions;
  }
}


transitions
@init { 
        //create a Transitions object when the rule is hit
        Transitions transitions = new Transitions();

        //store it to be accessed later.
        allTransitions.add(transitions);
      } 
 : ^(TRANSITIONS INT transitions_pair[transitions]+) //pass the object to transitions_pair for each PAIR encountered
 {
     System.out.println("transitions=" + $INT.text);
 }
 ;

transitions_pair[Transitions transitions]
 : ^(PAIR a=INT b=INT) 
 {
     System.out.println("pair=" + $a.text + ", " + $b.text);
     //make a call to the Transitions object that was passed to this rule.
     transitions.addPair(new Pair($a.int, $b.int));
 }
 ;