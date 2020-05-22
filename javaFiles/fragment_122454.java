gradle.ext.generatedQueriesDir = 'build/generated-sources/local/query'
/*
 * This is a workaround to delete the file that will be created by the annotation processor if it already exists.
 * There is a known bug in the Java compiler and JDK 8 which should be fixed at JDK 9.
 * http://bugs.java.com/bugdatabase/view_bug.do?bug_id=8067747 <-- Master report
 * http://bugs.java.com/bugdatabase/view_bug.do?bug_id=8146348 <-- duplicates master report
 */
if ( file( gradle.ext.generatedQueriesDir ).exists() ) {
  FileCollection collection = files { file( gradle.ext.generatedQueriesDir ).listFiles() }
  collection.each { delete it }
}