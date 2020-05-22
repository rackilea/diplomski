import java.lang.reflect.Method;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class ScriptEngineInterpreter
{
    private static final boolean DEBUG = false;
    final private ScriptEngine engine;
    final private Bindings bindings;
    final private StringBuilder sb;
    private int lineNumber;
    private int pendingLineCount;
    private boolean expectingMoreInput;

    /**
     * @param engine ScriptingEngine to use in this interpreter
     * @param bindings Bindings to use in this interpreter
     */
    public ScriptEngineInterpreter(ScriptEngine engine, Bindings bindings) 
    { 
        this.engine = engine; 
        this.bindings = bindings;
        this.sb = new StringBuilder();
        this.lineNumber = 0;
        reset();
    }       
    /** @return ScriptEngine used by this interpreter */
    public ScriptEngine getEngine() { return this.engine; }
    protected void reset() { 
        this.sb.setLength(0);
        this.pendingLineCount = 0;
        setExpectingMoreInput(false);
    }
    /** @return whether the interpreter is ready for a brand new statement. */
    public boolean isReady() { return this.sb.length() == 0; }
    /**
     * @return whether the interpreter expects more input
     * 
     * A true value means there is definitely more input needed.
     * A false value means no more input is needed, but it may not yet
     * be appropriate to evaluate all the pending lines.
     * (there's some ambiguity depending on the language)
     */
    public boolean isExpectingMoreInput() { return this.expectingMoreInput; }
    protected void setExpectingMoreInput(boolean b) { this.expectingMoreInput = b; }
    /**
     * @return number of lines pending execution
     */
    protected int getPendingLineCount() { return this.pendingLineCount; }
    /**
     * @param lineIsEmpty whether the last line is empty
     * @return whether we should evaluate the pending input
     * The default behavior is to evaluate if we only have one line of input,
     * or if the user enters a blank line.
     * This behavior should be overridden where appropriate.
     */
    protected boolean shouldEvaluatePendingInput(boolean lineIsEmpty) 
    {
        if (isExpectingMoreInput())
            return false;
        else
            return (getPendingLineCount() == 1) || lineIsEmpty; 
    } 
    /**
     * @param line line to interpret
     * @return value of the line (or null if there is still pending input)
     * @throws ScriptException in case of an exception
     */
    public Object interpret(String line) throws ScriptException
    {
        ++this.lineNumber;
        if (line.isEmpty())
        {
            if (!shouldEvaluatePendingInput(true))
                return null;
        }

        ++this.pendingLineCount;        
        this.sb.append(line);
        this.sb.append("\n");
        CompiledScript cs = tryCompiling(this.sb.toString(), getPendingLineCount(), line.length());

        if (cs == null)
        {
            return null;
        }
        else if (shouldEvaluatePendingInput(line.isEmpty()))
        {
            try
            {
                Object result = cs.eval(this.bindings);
                return result;
            }
            finally
            {
                reset();
            }
        }
        else
        {
            return null;
        }
    }
    private CompiledScript tryCompiling(String string, int lineCount, int lastLineLength)
        throws ScriptException 
    {
        CompiledScript result = null;
        try
        {
            Compilable c = (Compilable)this.engine;
            result = c.compile(string);
        }
        catch (ScriptException se) {
            boolean rethrow = true;
            if (se.getCause() != null)
            {
                Integer col = columnNumber(se);
                Integer line = lineNumber(se);
                /* swallow the exception if it occurs at the last character
                 * of the input (we may need to wait for more lines)
                 */
                if (col != null
                 && line != null 
                 && line.intValue() == lineCount 
                 && col.intValue() == lastLineLength)
                {
                    rethrow = false;
                }
                else if (DEBUG)
                {
                    String msg = se.getCause().getMessage();
                    System.err.println("L"+line+" C"+col+"("+lineCount+","+lastLineLength+"): "+msg);
                    System.err.println("in '"+string+"'");
                }
            }

            if (rethrow)
            {
                reset();
                throw se;
            }
        }

        setExpectingMoreInput(result == null);
        return result;
    }
    private Integer columnNumber(ScriptException se)
    {       
        if (se.getColumnNumber() >= 0)
            return se.getColumnNumber();
        return callMethod(se.getCause(), "columnNumber", Integer.class);
    }
    private Integer lineNumber(ScriptException se)
    {       
        if (se.getLineNumber() >= 0)
            return se.getLineNumber();
        return callMethod(se.getCause(), "lineNumber", Integer.class);
    }
    static private Method getMethod(Object object, String methodName)
    {
        try {
            return object.getClass().getMethod(methodName);
        }
        catch (NoSuchMethodException e) {
            return null;
            /* gulp */ 
        }
    }
    static private <T> T callMethod(Object object, String methodName, Class<T> cl) {
        try {
            Method m = getMethod(object, methodName);
            if (m != null)
            {
                Object result = m.invoke(object); 
                return cl.cast(result);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}