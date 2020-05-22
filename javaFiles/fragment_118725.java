public class script1440427072752 extends groovy.lang.Script { 

    public script1440427072752() {
    }

    public script1440427072752(groovy.lang.Binding context) {
        super(context)
    }

    public static void main(java.lang.String[] args) {
        org.codehaus.groovy.runtime.InvokerHelper.runScript(script1440427072752, args)
    }

    public java.lang.Object run() {
        new A().greet()
    }

}
public class A extends java.lang.Object { 

    public java.lang.Object greet() {
        this.println('Hey there!')
    }

}