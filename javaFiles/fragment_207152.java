task gcloudExec1(type:Exec) {
    commandline 'gcloud', 'preview', 'app', 'deploy'
    args "--dockerHost=tcp:"
    args "--version=1.4.1"
    ....
    args AppEnginePlugin.getExplodedAppDir(project).absolutepath
}