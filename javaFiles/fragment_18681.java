//Copyright Hugh Perkins 2012, hughperkins -at- gmail
//
//This Source Code Form is subject to the terms of the Mozilla Public License, 
//v. 2.0. If a copy of the MPL was not distributed with this file, You can 
//obtain one at http://mozilla.org/MPL/2.0/.

package root.javalanguage.realtemplates;

import java.lang.annotation.*;
import java.util.*;

public class RealTemplateGenerator {
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.SOURCE)
    public @interface GenerateFrom {
        Class<?> value();
    }
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.SOURCE)
    public @interface GenerateArg {
        Class<?> from();
        Class<?> to();
    }
public final static BufferedReader newBufferedReader(String filepath ) throws Exception {
    FileInputStream fileInputStream = new FileInputStream( filepath );
    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
    return bufferedReader;
}

public final static BufferedWriter newBufferedWriter( String filepath ) throws Exception {
    FileOutputStream fileOutputStream = new FileOutputStream(filepath);
    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
    return bufferedWriter;
}

public final static ArrayList<String> readFileAsLines(String filepath ) throws Exception {
    ArrayList<String> lines = new ArrayList<String>(40000);

    BufferedReader bufferedReader = newBufferedReader(filepath);

    String line = bufferedReader.readLine();
    int numlines = 0;
    while( line != null ) {
        lines.add(line.substring(0, line.length() ));
        line = bufferedReader.readLine();
        numlines++;
    }
    bufferedReader.close();
    return lines;
}

public final static void writeFileFromLines( String filepath, ArrayList<String> lines ) throws Exception {
    BufferedWriter bufferedWriter = newBufferedWriter(filepath);
    for( String line : lines ) {
        bufferedWriter.write(line + "\n");
    }
    bufferedWriter.close();
}

    void go( String sourcedirectory, Class<?> targetclass ) throws Exception {
        String targetclassfilepath = sourcedirectory + "/" + targetclass.getCanonicalName().replace(".","/") + ".java";
        ArrayList<String> initialLines = FileHelper.readFileAsLines(targetclassfilepath);
        String fromclassname = "";
        HashMap<String,String> argOldToNew = new HashMap<String, String>();
        ArrayList<String> generatelines = new ArrayList<String>();
        for( String line : initialLines ) {
            if( line.startsWith("@GenerateFrom")){
                fromclassname = line.split("\\(")[1].split("\\.class")[0];
            }
            if( line.startsWith("@GenerateArg")) {
                String fromclass= line.split("from=")[1].split("\\.")[0];
                String toclass = line.split("to=")[1].split("\\.")[0];
                argOldToNew.put(fromclass,toclass);
                generatelines.add(line);
            }   
        }
        Class<?> targettype = this.getClass().forName(fromclassname); 
        String fromclassfilepath = sourcedirectory + "/" + targettype.getCanonicalName().replace(".","/") + ".java";
        ArrayList<String> templateLines = FileHelper.readFileAsLines(fromclassfilepath );
        ArrayList<String> generatedLines = new ArrayList<String>();
        for( int i = 0; i < templateLines.size(); i++ ){
            String line = templateLines.get(i);
            if( !line.startsWith("@GenerateFrom") && !line.startsWith("@GenerateArg")) {
                for( String oldarg : argOldToNew.keySet() ) {
                    line = line.replace(oldarg, argOldToNew.get(oldarg));
                }
                line = line.replace(targettype.getSimpleName(), targetclass.getSimpleName());
            } else if( line.startsWith("@GenerateFrom") ) {
                for( String generateline : generatelines ) {
                    generatedLines.add(generateline);
                }
            }
            generatedLines.add(line);
        }
        boolean isModified = false;
        if( initialLines.size() != generatedLines.size() ) {
            isModified = true;
        } else {
            for(int i = 0; i < initialLines.size(); i++ ) {
                if( !initialLines.get(i).equals(generatedLines.get(i))) {
                    isModified = true;
                    break;
                }
            }
        }
        if( isModified ) {
            FileHelper.writeFileFromLines(targetclassfilepath, generatedLines);
            System.out.println("Generated " + targetclassfilepath );
        } else {
            System.out.println("No change to " + targetclassfilepath );         
        }
    }
    public static void main(String[] args ) throws Exception {
        new RealTemplateGenerator().go("/data/dev/machinelearning/MlPrototyping", EndlessArrayDouble.class);
    }
}