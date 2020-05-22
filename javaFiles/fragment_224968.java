dyn.load('/Library/Java/JavaVirtualMachines/jdk1.8.0_162.jdk/Contents/Home/jre/lib/server/libjvm.dylib')

remove.packages("rJava")
install.packages("rJava")

ipak <- function(pkg){
  new.pkg <- pkg[!(pkg %in% installed.packages()[, "Package"])]
  if (length(new.pkg))
    install.packages(new.pkg, dependencies = TRUE)
  sapply(pkg, require, character.only = TRUE)
}

# usage
packages <- c("NLP", "coreNLP", "rJava")
ipak(packages)

.jinit()
.jcall("java/lang/System","S","getProperty","java.version")

# run the follwoing command once
# downloadCoreNLP() # <- Takes a while...

initCoreNLP()
example(getSentiment)
sIn <- "Mother died today. Or, maybe, yesterday; I can't be sure."
annoObj <- annotateString(sIn)