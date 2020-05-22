public static void main(String[] args) {
    // your data
    String data = "Symbol Ticker:1466654463000:157.71:TRADE:42|Symbol Ticker:1466654463000:157.71:TRADE:42|Symbol Ticker:1466654463000:157.71:TRADE:42|Symbol Ticker:1466654463000:157.71:TRADE:42|Symbol Ticker:1466654463000:157.71:TRADE:42|Symbol Ticker:1466654463000:157.71:TRADE:42|Symbol Ticker:1466654463000:157.71:TRADE:42|Symbol Ticker:1466654463000:157.71:TRADE:42|Symbol Ticker:1466654463000:157.71:TRADE:42|Symbol Ticker:1466654463000:157.71:TRADE:42|Symbol Ticker:1466654463000:157.71:TRADE:42|Symbol Ticker:1466654463000:157.71:TRADE:42|";
    // do the split
    List<String> out = new Test().splitToApproxAt(data, 200);
    // print the splitted lines
    for(String o : out){
        System.out.println(o);
    }
}

public List<String> splitToApproxAt(String data, int len){
    // split at the pipe symbol "|"
    String[] parts = data.split("\\|");

    // this will be our current line in progress
    String line = "";

    // this will store the lines up to 200 chars
    List<String> out = new ArrayList<String>();

    // for every data-part
    for( String part : parts ){
        if(part.length() > len){
            System.out.println("oh shit, what do?");
            continue;
        }
        // would this exceed the 200 chars?
        if( line.length() + part.length() > len){
            // yes! add previous line to output
            // and start a new one.
            out.add(line);
            line = part;
        }else{
            // no we can attach that to the
            // current line
            if(line.length()>0){
                // delimit with pipe
                line += "|" +part;
            }else{
                // line was empty, no pipe
                line = part;
            }
        }
    }
    // add the last line to the output
    out.add(line);
    return out;
}