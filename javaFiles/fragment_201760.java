package com.conceptualsystems.dialog;

[...import statements...]

public interface Command {
    public void execute();

    public static final Command NO_OP = new Command() { public void execute() {} };
}