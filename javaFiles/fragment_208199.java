JShell shell = JShell.create();
          shell.eval("int x = 5;");
          shell.eval("x = 7;");

    shell.snippets().forEach(s1->shell.drop(s1));

    shell.snippets().forEach(s2->{
        System.out.println(shell.status(s2));   //DROPPED
    });

   shell.snippets().forEach(System.out::println);  //we print all active and inactive snippets