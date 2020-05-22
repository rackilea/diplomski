#
 # Optional ENV vars
 # -----------------
 #   M2_HOME - location of maven2's installed home dir
 #   MAVEN_OPTS - parameters passed to the Java VM when running Maven
 #     e.g. to debug Maven itself, use
 #       set MAVEN_OPTS=-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=8000
 #   MAVEN_SKIP_RC - flag to disable loading of mavenrc files
 # ----------------------------------------------------------------------------

 if [ -z "$MAVEN_SKIP_RC" ] ; then

   if [ -f /etc/mavenrc ] ; then
     . /etc/mavenrc
   fi

   if [ -f "$HOME/.mavenrc" ] ; then
     . "$HOME/.mavenrc"
   fi

 fi