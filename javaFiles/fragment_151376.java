String fileName = SourceLocator.v().getFileNameFor(sClass, Options.output_format_class);
OutputStream streamOut = new JasminOutputStream(new FileOutputStream(fileName));
PrintWriter writerOut = new PrintWriter(new OutputStreamWriter(streamOut));

JasminClass jasminClass = new soot.jimple.JasminClass(sClass);
jasminClass.print(writerOut);
writerOut.flush();
streamOut.close();