node {
 sh """
  git clone ...
  git checkout master
  git merge $theVariableContainingTagNameYouConfigured
 """
}