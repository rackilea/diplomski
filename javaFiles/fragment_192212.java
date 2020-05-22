public class DecimalTextFormatter extends TextFormatter<Number> {
private static DecimalFormat format = new DecimalFormat( "#.0;-#.0" );
public DecimalTextFormatter(int minDecimals, int maxDecimals) {
    super(
        new StringConverter<Number>() {
            @Override
            public String toString(Number object) {
                if(object == null){
                    return "";
                }
                String format = "0.";
                for (int i = 0; i < maxDecimals; i++) {
                    if(i < minDecimals ) {
                        format = format + "0" ;
                    }else {
                        format = format + "#" ;
                    }
                }
                format = format + ";-" + format;
                DecimalFormat df = new DecimalFormat(format);
                String formatted =  df.format(object);
                return formatted;
            }

            @Override
            public Number fromString(String string){
                try {
                    return format.parse(string);
                } catch (ParseException e) {
                    return null;
                }
            }
        },
        0,
        new UnaryOperator<TextFormatter.Change>() {
            @Override
            public TextFormatter.Change apply(TextFormatter.Change change) {
                if ( change.getControlNewText().isEmpty() )
                {
                    return change;
                }

                ParsePosition parsePosition = new ParsePosition( 0 );
                Object object = format.parse( change.getControlNewText(), parsePosition );

                if(change.getControlNewText().equals("-")){
                    return change;
                }

                if(change.getCaretPosition() == 1){
                    if(change.getControlNewText().equals(".")){
                        return change;
                    }
                }

                if ( object == null || parsePosition.getIndex() < change.getControlNewText().length() )
                {
                    return null;
                }
                else
                {
                    int decPos = change.getControlNewText().indexOf(".");
                    if(decPos > 0){
                        int numberOfDecimals = change.getControlNewText().substring(decPos+1).length();
                        if(numberOfDecimals > maxDecimals){
                            return null;
                        }
                    }
                    return change;
                }
            }
        }
    );
}