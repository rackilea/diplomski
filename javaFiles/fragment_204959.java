jar 
{
    from sourceSets.generated.output
    from sourceSets.bootstrap.output
    dependsOn bootstrapClasses
    dependsOn generatedClasses
}