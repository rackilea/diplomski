//STDENV   DD *                                              
#                                                            
# Java home location                                         
#                                                            
export JAVA_HOME=/your/omvs/path/to/java/lib
#                                                            
# Standard java path updates                                 
#                                                            
export PATH=/bin:"${JAVA_HOME}"/bin                          
LIBPATH=/lib:/usr/lib:"${JAVA_HOME}"/bin                     
LIBPATH="$LIBPATH":"${JAVA_HOME}"/lib/s390                   
LIBPATH="$LIBPATH":"${JAVA_HOME}"/lib/s390/j9vm              
LIBPATH="$LIBPATH":"${JAVA_HOME}"/bin/classic                
export LIBPATH="$LIBPATH":                                   
#                                                            
# Define location (and version if applicable) of jar home    
#                                                            
APP_HOME=/var/location/of/your/jar                                       
CLASSPATH=$APP_HOME:"${JAVA_HOME}"/lib:"${JAVA_HOME}"/lib/ext
# Add Application required jars to end of CLASSPATH          
for i in "${APP_HOME}"/*.jar; do                             
    CLASSPATH="$CLASSPATH":"$i"                              
    done                                                     
export CLASSPATH="$CLASSPATH":                               
//