package de.scrum_master.aspect;

import de.scrum_master.base.BasicInterface;
import de.scrum_master.base.ApplicationBase;

public aspect ApplicationContractEnforcer {
  declare error :
    within(de.scrum_master..*) &&
    execution(public static void main(String[])) &&
    !within(BasicInterface+) &&
    !within(ApplicationBase+)
  : "Applications with main methods have to implement BasicInterface or extend ApplicationBase";
}