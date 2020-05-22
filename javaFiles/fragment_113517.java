octave:6> help urlread
'urlread' is a function from the file /usr/lib/octave/3.6.4/oct/i686-redhat-linux-gnu/urlwrite.oct

 -- Loadable Function: S = urlread (URL)
 -- Loadable Function: [S, SUCCESS] = urlread (URL)
 -- Loadable Function: [S, SUCCESS, MESSAGE] = urlread (URL)
 -- Loadable Function: [...] = urlread (URL, METHOD, PARAM)
     Download a remote file specified by its URL and return its content
     in string S.  For example:

          s = urlread ("ftp://ftp.octave.org/pub/octave/README");

     The variable SUCCESS is 1 if the download was successful,
     otherwise it is 0 in which case MESSAGE contains an error message.
     If no output argument is specified and an error occurs, then the
     error is signaled through Octave's error handling mechanism.

     This function uses libcurl.  Curl supports, among others, the HTTP,
     FTP and FILE protocols.  Username and password may be specified in
     the URL.  For example:

          s = urlread ("http://user:password@example.com/file.txt");

     GET and POST requests can be specified by METHOD and PARAM.  The
     parameter METHOD is either `get' or `post' and PARAM is a cell
     array of parameter and value pairs.  For example:

          s = urlread ("http://www.google.com/search", "get",
                      {"query", "octave"});

     See also: urlwrite



Additional help for built-in functions and operators is
available in the online version of the manual.  Use the command
'doc <topic>' to search the manual index.

Help and information about Octave is also available on the WWW
at http://www.octave.org and via the help@octave.org