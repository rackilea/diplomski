node('Slaves')
{
    stage('Build with coverage and All tests') {

    echo 'Starting build with ALL unittests'
        withMaven(jdk: 'JDK6') {
        //execute maven with java6
        }
    }
    stage('Execute Sonar') {
    //do other stuff
        withMaven(jdk: 'JDK8') {
        //execute maven with java8
        }
    }

}