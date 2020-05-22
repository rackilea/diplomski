import java.util.Properties;
import org.python.util.PythonInterpreter;

(...)

Properties properties = new Properties();
properties.setProperty("python.path", pythonPath);
PythonInterpreter.initialize(System.getProperties(), properties, new String[] { "" });
PythonInterpreter pythonInterpreter = new PythonInterpreter();
pythonInterpreter.exec("import codecs");
pythonInterpreter.exec("codecs.getreader('utf8')");