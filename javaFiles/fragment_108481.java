@PostMapping("/usuarios/{idUsuario}/permisos")
 public Usuario addPermisoUsuario(@PathVariable(value = "idUsuario") Integer 
 userId, @RequestBody Permiso permiso) {
    Usuario user = userRepository.findOne(userId);
    Permiso permisoExistente = 
    permisoRepository.findOne(permiso.getIdPermiso());
    user.getPermisoCollection().add(permisoExistente);
    return userRepository.save(user);
 }

 @DeleteMapping("/usuarios/{idUsuario}/permisos/{idPermiso}")
 public Usuario deletePermisoUsuario(@PathVariable(value = "idUsuario") 
 Integer userId, @PathVariable(value = "idPermiso") 
 Integer permisoId, @RequestBody Permiso permiso) {
    Usuario user = userRepository.findOne(userId);
    Permiso permisoEliminar = permisoRepository.findOne(permisoId);
    user.getPermisoCollection().remove(permisoEliminar);
    return userRepository.save(user);
 }