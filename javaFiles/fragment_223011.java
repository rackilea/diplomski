pipeline {
    agent any

    stages {

        stage("jdk6") {
            tools {
                jdk "jdk6"
                maven "3.2.5" // latest Maven, which supports JDK 6
            }
            steps {
                sh "java -version"
                sh "mvn --version"
            }
        }

        stage("jdk8") {
            tools {
                jdk "jdk8"
                maven "3.5.4"
            }
            steps {
                sh "java -version"
                sh "mvn --version"
            }
        }
    }
}