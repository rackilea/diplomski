apply plugin: 'java' // adds 'test' task

test {
  // ...

  // explicitly include or exclude tests
  include 'org/foo/**'
  exclude 'org/boo/**'

  // ...
}