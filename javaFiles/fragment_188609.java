interceptors.put("test",
        testInterceptor);

 executeExpression(compileExpression("@test System.out.println('MIDDLE');",
        null,
        interceptors));