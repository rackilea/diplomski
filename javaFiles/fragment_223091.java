import com.stanfy.spoon.gradle.SpoonRunTask
task spoonAuthFlowTests(type: SpoonRunTask) {
  instrumentationArgs = ['package=com.myapp.instrumentation.flowtests.AuthFlowTests']
  // But you will have to set many other options on the tasks,
  // like instrumentationApk and applicationApk files.
}