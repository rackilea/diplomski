import java.util.ArrayList;
import java.util.List;

public class DailyRule {
public String type;
public List<String> set = new ArrayList<String>();
public List<Object> args;
String op;
String cond;

public String getType(){
    return type;
}

public String getOp(){
    return op;
}

public String getCond(){
    return cond;
}

public List<String> getSet(){
    return set;
}
public List<Object> getArgs() {
    return args;
}

@Override
public String toString() {
   return type+" "+set.toString()+" "+args.toString();
}
}