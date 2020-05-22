pipeline {
    agent {
        docker {
            image 'maven:3.6.1'
            args '-v /var/lib/jenkins:/usr/src/mymaven -w /usr/src/mymaven'
        }
    }
    stages {
        stage('build') {
            steps {
                sh 'MAVEN_OPTS="-Duser.home=/usr/src/mymaven" mvn clean verify -Dmaven.test.failure.ignore=true'
            }
            // ...
        }
    }
}