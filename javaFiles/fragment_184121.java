pipeline {
    agent {
        label 'master'
    }

    environment  {
        //foo var
        foo = "Hello !";
    }

    stages {
        stage("test-var") {
            steps {
                // If you are using LINUX use EXPORT
                bat "set foo=\"${env.foo}\""
                bat "java -jar /someplace/DummyMain.jar"
            }
        }
    }
}