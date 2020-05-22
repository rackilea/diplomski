compile jarjar.repackage {
    from 'org.apache.hive:hive-exec:0.13.0.2.1.5.0-695'

    archiveBypass "commons*.jar"
    archiveExclude "slf4j*.jar"

    classDelete "org.apache.thrift.**"
    classRename 'org.json.**', 'org.anarres.hive.json.@1'
}