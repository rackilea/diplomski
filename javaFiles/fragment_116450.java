In[1]:= Needs["JLink`"]

In[2]:= Options[ReinstallJava]

Out[2]= {ClassPath -> Automatic, CommandLine -> Automatic, 
 JVMArguments -> None, ForceLaunch -> False, Default -> Automatic, 
 CreateExtraLinks -> Automatic, "Asynchronous" -> Automatic}

In[3]:= ?JVMArguments

JVMArguments is an option to InstallJava that
allows you to specify additional command-line
arguments passed to the Java virtual machine at
startup. The string you specify is added to the
command line used to launch Java. You can use this
option to specify properties with the standard -D
syntax, such as "-Dsome.property=true". This
option is not supported on Mac OSX. >>

In[4]:= LoadJavaClass["java.lang.Runtime"];

In[5]:= java`lang`Runtime`getRuntime[]@maxMemory[]

Out[5]= 238616576

In[6]:= ReinstallJava[JVMArguments -> "-Xmx64g"];

In[7]:= LoadJavaClass["java.lang.Runtime"];

In[8]:= java`lang`Runtime`getRuntime[]@maxMemory[]

Out[8]= 61084008448