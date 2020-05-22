public class MyConsequenceException extends RuntimeException {
private final WorkingMemory workingMemory;
private final Activation activation;

public MyConsequenceException(final Activation activation, final WorkingMemory workingMemory, final Exception exception) {
    super(exception);
    this.activation = activation;
    this.workingMemory = workingMemory;
}

@Override
public String getMessage() {
    StringBuilder sb = new StringBuilder( "Exception executing consequence for " );
    if( activation != null && ( activation.getRule() ) != null ){
        Rule rule = activation.getRule();
        String ruleName = rule.getName();
        sb.append("rule [\"").append( ruleName ).append( "\"]. " );
    } else {
        sb.append( "rule, name unknown" );
    }
    Throwable throwable = ExceptionUtils.getRootCause(getCause());
    sb.append("The thrown exception is [").append(throwable).append("]. ");
    return sb.toString();
}

@Override
public String toString() {
    return getMessage();
}