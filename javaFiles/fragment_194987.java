public class HelpOptionHandler extends BooleanOptionHandler {
    public HelpOptionHandler(CmdLineParser parser, OptionDef option, Setter<Boolean> setter) {
        super(parser, option, setter);
    }
    public String printDefaultValue() {
         return null;  // this prevents the default value to be printed in usage info
    }
}