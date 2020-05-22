//****************************************************************************
//***** File Name: MianCLIOptions.java
//****************************************************************************

package com.test.mian;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.cli.AlreadySelectedException;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.MissingOptionException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.UnrecognizedOptionException;
import org.apache.commons.lang.WordUtils;


//****************************************************************************
//****************************************************************************
//****************************************************************************
//****************************************************************************
public class MianCLIOptions
{
    //***** constants *****

    //***** public data members *****

    //***** private data members *****
    private static MianCLIOptions singletonObj = null;

    private HashMap<String,Object> options = new HashMap<String,Object>();
    private ArrayList<String> arguments = new ArrayList<String>();

    //****************************************************************************
    public static MianCLIOptions getopts()
    {
        if (singletonObj == null) {
            throw new IllegalStateException("[MianCLIOptions] Command line not yet initialized.");
        }

        return singletonObj;
    }

    //****************************************************************************
    public static synchronized void initialize(Options optsdef, String[] args)
        throws MianCLIOptionsException, UnrecognizedOptionException, MissingArgumentException,
               MissingOptionException, AlreadySelectedException, ParseException
    {
        if (singletonObj == null) {
            singletonObj = new MianCLIOptions(optsdef, args);
        }
        else {
            throw new IllegalStateException("[MianCLIOptions] Command line already initialized.");
        }
    }

    //****************************************************************************
    //----- prevent cloning -----
    public Object clone() throws CloneNotSupportedException
    {
        throw new CloneNotSupportedException();
    }

    //****************************************************************************
    public boolean isset(String opt)
    {
        return options.containsKey(opt);
    }

    //****************************************************************************
    public Object getopt(String opt)
    {
        Object rc = null;

        if (options.containsKey(opt)) {
            rc = options.get(opt);
        }

        return rc;
    }

    //****************************************************************************
    //***** finally parse the command line
    //****************************************************************************
    private MianCLIOptions(Options optsdef, String[] args)
        throws UnrecognizedOptionException, MissingArgumentException,
               MissingOptionException, AlreadySelectedException, ParseException
    {
        //***** (blindly) parse the command line *****
        CommandLineParser parser = new GnuParser();
        CommandLine cmdline = parser.parse(optsdef, args);

        //***** store options and arguments *****
        //----- options -----
        for (Option opt : cmdline.getOptions()) {
            String key = opt.getOpt();
            if (opt.hasArgs()) {
                options.put(key, opt.getValuesList());
            }
            else {
                options.put(key, opt.getValue());
            }
        }

        //----- arguments -----
        for (String str : cmdline.getArgs()) {
            //----- account for ant/build.xml/generic -----
            if (str.length() > 0) {
                arguments.add(str);
            }
        }
    }
}

//****************************************************************************
//***** EOF  ***** EOF  ***** EOF  ***** EOF  ***** EOF  ***** EOF  **********