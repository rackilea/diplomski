@PreAuthorize(hasRole('ROLE_ADMIN'||'ROLE_USER'))
@RequesMapping(value="/doblahblah")
public String doBlahBlahh(){
    methodOnlyAdminCanExecute();
    methodOnlyUserCanExecute();
}

@PreAuthorize(hasRole('ROLE_USER'))
@RequesMapping(value="/douserstuff")
public String douserstuff(){
    methodOnlyAdminCanExecute();
    methodOnlyUserCanExecute();
}