android {

...


    packagingOptions {
           exclude  'org/apache/http/annotation/NotThreadSafe.class'
    }
}