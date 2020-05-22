String sootClassPath = srcDir + ":" 
            + javaHome + "/jre/lib/rt.jar:"
            +javaHome + "/jre/lib/jce.jar";

    Options.v().set_output_format(Options.output_format_jimple);
    Options.v().set_src_prec(Options.src_prec_java);

    for (String className : classNames) { // // "className" is like a.b.Myclass
        Options.v().classes().add(className);
    }

    Options.v().set_keep_line_number(true);
    Options.v().set_allow_phantom_refs(true);
    Scene.v().setSootClassPath(sootClassPath);

    Scene.v().loadBasicClasses();