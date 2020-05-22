import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;

StringTemplate hello = new StringTemplate("Hello, $name$", DefaultTemplateLexer.class);
hello.setAttribute("name", "World");
System.out.println(hello.toString());