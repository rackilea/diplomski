JAVA_VERSION=7
JAVA_7_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_75.jdk/Contents/Home
JAVA_8_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home

tmp="JAVA_${JAVA_VERSION}_HOME"
export JAVA_HOME=${!tmp}
export PATH=${!j}/bin:$PATH