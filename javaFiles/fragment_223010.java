pipeline {

    stage("jdk6") {
        environment {
            JAVA_HOME = "/usr/lib/jvm/oracle-java6-jdk-amd64"
        }
        steps {
            sh "java -version"
            sh "mvn --version"
        }
    }
    stage("jdk8") {
        environment {
            JAVA_HOME = "/usr/lib/jvm/oracle-java8-jdk-amd64"
        }
        steps {
            sh "java -version"
            sh "mvn --version"
        }
    }
}