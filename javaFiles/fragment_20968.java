ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    String js = "var fileSrc = '<SPAN>06-24-2015  11:28AM  0250 01 90775 05342</SPAN>';"
            + "var trans_regex = /\\<span\\>(\\d{2}-\\d{2}-\\d{4})\\s*?(\\d{1,2}:\\d{2}\\s*?(?:am|pm))\\s*?(?:<\\/SPAN><BR\\/?><SPAN>)?\\s*?((\\d[ -]*?){13,17})\\s*?[^<]*?\\<\\/span\\>/i ;"
            + "print('executed regex result : ' + trans_regex.exec(fileSrc) ) ; "
            + "var t_time = trans_regex.exec(fileSrc)[2];"
            + "var t_cc = trans_regex.exec(fileSrc)[3];"
            + "print(\" time \" + t_time)";

    Object result = engine.eval(js);