task usernameMaxio(type: Copy) {
  from 'src/main/resources/properties'
  into 'build/resources/main/properties'
  expand([
    username: 'Maxio'
  ])
}