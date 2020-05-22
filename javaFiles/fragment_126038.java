package de.scrum_master.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareError;

@Aspect
public class ApplicationContractEnforcer2 {
  @DeclareError(
    "within(de.scrum_master..*) && " +
    "execution(public static void main(String[])) && " +
    "!within(de.scrum_master.base.BasicInterface+) && " +
    "!within(de.scrum_master.base.ApplicationBase+)"
  )
  static final String errorMessage =
    "Applications with main methods have to implement BasicInterface or extend ApplicationBase";
}