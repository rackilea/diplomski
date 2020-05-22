public abstract class CommandClass<E extends Enum<E>> {
..........
    public abstract void updateUIBySubCmd(E x);
}

public class CommandOne extends CommandClass<SubCommand> {
    ........

    @Override
    public void updateUIBySubCmd(SubCommand subCmd){
          /*Do Something*/
    }
}

public enum SubCommand {
    SubCmd1    (ID1, Name1),
    SubCmd2    (ID2, Name2),
    ........
}