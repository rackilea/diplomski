pointcut intercept_call() : call(public * execute(java.lang.String, ..));


 before(String val): intercept_call() && !cflowbelow(intercept_call()) && args(val, ..)
{

    // do soemthing
   }
}