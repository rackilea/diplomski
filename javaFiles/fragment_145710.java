ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Application.class).web(false).run(args);

try {
    doSomething(ctx);
} catch (Exception e){
    //abort
} finally {
    ctx.close();
}

//New context has web enabled.
ctx = new SpringApplicationBuilder(Application.class).run(args);
doSomething(ctx);