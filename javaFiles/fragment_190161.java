String osName = System.getProperty("os.name").toLowerCase();
boolean isMacOs = osName.startsWith("mac os x");
String macPythonPath = "/Library/Frameworks/Python.framework/Versions/3.6/bin/python3";
String unixPythonPath = "/usr/bin/python3";
String filepath = "/Users/inanc/Desktop/pythonDocs/hw1additionalInputs.py ";
Process p;
if (isMacOs){
    p = Runtime.getRuntime().exec(macPythonPath + " -m py_compile " + filepath);

}
else{
    p = Runtime.getRuntime().exec(unixPythonPath + " -m py_compile " + filepath);   
}

BufferedReader stdError = new BufferedReader(new 
        InputStreamReader(p.getErrorStream()));


String resError = "", s;
// read any errors from the attempted command
while ((s = stdError.readLine()) != null) {
    resError = resError + s + "\n";
}
resError = resError.trim();
stdError.close();

if(resError.equals("")) {


    if (isMacOs){
        p = Runtime.getRuntime().exec(macPythonPath + " " + filepath);

    }
    else{
        p = Runtime.getRuntime().exec(unixPythonPath + " " + filepath); 
    }

    BufferedReader stdInput = new BufferedReader(new 
            InputStreamReader(p.getInputStream()));

    stdError = new BufferedReader(new 
            InputStreamReader(p.getErrorStream()));

    // read the output from the command
    String res = ""; 
    s = null;
    String[] inputs = {"10", "20"};
    OutputStream out = p.getOutputStream();


    for(String input:inputs){
        if(input.equals("") == false)
        {

            Thread.sleep(200);
            while (stdInput.ready() && (s = "" + (char) stdInput.read()) != null) {
                res = res + s ;

            }

            // read any errors from the attempted command
            Thread.sleep(200);
            while (stdError.ready() && (s = "" + (char) stdError.read()) != null) {
                resError = resError + s;
            }

            if(resError.equals("") == false)
                break;

            out.write((input+"\n").getBytes());
            out.flush();
            res = res + input + "\n";

            Thread.sleep(200);
            while (stdInput.ready() && (s = "" + (char) stdInput.read()) != null) {
                res = res + s ;

            }
            //res = res.trim();

            // read any errors from the attempted command
            Thread.sleep(200);
            while (stdError.ready() && (s = "" + (char) stdError.read()) != null) {
                resError = resError + s;
            }
            if(resError.equals("") == false)
                break;


        }
    }

    Thread.sleep(200);
    while (stdInput.ready() && (s = "" + (char) stdInput.read()) != null) {
        res = res + s ;

    }
    //res = res.trim();

    // this part is for in case of no inputs
    Thread.sleep(200);
    while (stdError.ready() && (s = "" + (char) stdError.read()) != null) {
        resError = resError + s;
    }
    stdInput.close();
    stdError.close();
    if(p.isAlive())
    {
        System.err.println("Timeout");
        p.destroy();
    }
    p = null;
    System.out.println(res);
    System.out.println(resError);
}
else {
    System.err.println(resError);
}