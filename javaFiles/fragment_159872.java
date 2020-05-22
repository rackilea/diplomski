withTransaction {
  UserData data = new UserData(prop: zombieUser.userData.prop)
  liveUser.userData = data
  zombiUser.delete()
  liveUser.save()
}