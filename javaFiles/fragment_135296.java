$ alias myjruby="java -cp ${JRUBY_HOME}/lib/jruby.jar:${HOME}/.m2/repository/org/apache/commons/commons-lang3/3.4/commons-lang3-3.4.jar org.jruby.Main"

# Verifying base jruby code works with that:
$ myjruby -e 'puts 2+2'
4

# Now verifying it can use my 3rd-party lib:
$ myjruby -e 'puts org.apache.commons.lang3.mutable.MutableBoolean.new'
false