import com.sun.tools.javac.api.JavacTaskImpl;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.main.JavaCompiler;
// ...

JavacTask javacTask = getJavacTask();
Context context = ((JavacTaskImpl)javacTask).getContext();
JavaCompiler compiler = JavaCompiler.instance( context );