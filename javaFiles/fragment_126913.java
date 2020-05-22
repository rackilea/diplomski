loginUser(user:any){
  showErrorMessage = false;
  this.userService.loginUser(user).subscribe(
      (response) => {

      console.log("test");
          if (response) {
              console.log(response.token);
          if (response.token) {
              localStorage.setItem('currentUser', JSON.stringify(response));
          if (response.user.role === 'ADMIN') {
              this.router.navigate(['/admindashboard']);
      }   else {
              this.router.navigate(['/userdashboard']);
      }
    } else {
      console.log("No Token");
    }
  }
},
(error) => {
  showErrorMessage = true;
}