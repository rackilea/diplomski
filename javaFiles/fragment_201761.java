package com.conceptualsystems.dialog;

[...import statements...]

public class CommandWrapper implements DialogInterface.OnClickListener {
    private Command command;
    public CommandWrapper(Command command) {
        this.command = command;
    }

    public void execute() {
        command.execute();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        dialog.dismiss();
        command.execute();
    }
}